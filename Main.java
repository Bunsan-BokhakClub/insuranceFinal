import compensation.CompensationClaim;
import compensation.CompensationClaimListImpl;
import compensation.Survey;
import complaint.Complaint;
import complaint.ComplaintListImpl;
import contract.Contract;
import contract.ContractListImpl;
import customer.Customer;
import customer.CustomerList;
import customer.CustomerListImpl;
import customer.familyHistory.FamilyHistory;
import customer.familyHistory.FamilyHistoryImpl;
import customer.personalHistory.PersonalHistory;
import customer.personalHistory.PersonalHistoryImpl;
import employee.Employee;
import employee.EmployeeListImpl;
import employee.sellingRecord.SellingRecord;
import exception.CustomException;
import insurance.*;
import contract.tempContract.TempContract;
import contract.tempContract.TempContractListImpl;
import partner.Partner;
import partner.PartnerListImpl;
import partner.rate.Rate;
import payment.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int insuranceIndex = 1;
    private static int tempContractIndex = 1;

    private static TempContractListImpl tempContractList; // 보험 가입 신청 내역을 저장하는 리스트

    private static ContractListImpl contractList;
    private static PartnerListImpl partnerList;
    private static CompensationClaimListImpl compensationClaimList;
    private static InsuranceListImpl insuranceList;
    private static CustomerList customerList;
    private static ComplaintListImpl complaintList;
    private static EmployeeListImpl employeeList;




    public static void main(String[] args) throws IOException {
        insuranceList = new InsuranceListImpl();

        contractList = new ContractListImpl();

        partnerList = new PartnerListImpl();

        compensationClaimList = new CompensationClaimListImpl();

        customerList = new CustomerListImpl();

        tempContractList = new TempContractListImpl();

        employeeList = new EmployeeListImpl();
        complaintList = new ComplaintListImpl();
        createDummyDate();
        String userChoice = "";
        while (!userChoice.equals("x")) {
            showMenu();
            try {
                userChoice = br.readLine().trim();
                switch (userChoice) {
                    case "1":
                        claimInsurance();
                        break;
                    case "2":
                        queryInsurance();
                        break;
                    case "3":
                        checkMyInsurance();
                        break;
                    case "4":
                        fileComplaint();
                        break;
                    case "5":
                        payInsurance();
                        break;
                    case "6":
                        queryPartnerCompanies();
                        break;
                    case "7":
                        assessDamage();
                        break;
                    case "8":
                        registerInsurance();
                        break;
                    case "9":
                        modifyInsurance();
                        break;
                    case "10":
                        queryCustomerInfo();
                        break;
                    case "11":
                        queryEmployeeInfo();
                        break;
                    case "12":
                        queryContractInfo();
                        break;
                    case "13":
                        queryInsuranceApplication();
                        break;
                    case "x":
                        break;
                    default:
                        if (!userChoice.equals("x")) {
                            System.out.println("Invalid choice. Please try again.");
                        }
                }
            } catch(CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. 보상금 청구");
        System.out.println("2. 보험 조회");
        System.out.println("3. 내 보험 확인");
        System.out.println("4. 민원 접수");
        System.out.println("5. 보험금 납부");
        System.out.println("6. 협력 업체 조회");
        System.out.println("7. 손해 사정 한다");
        System.out.println("8. 보험 등록한다");
        System.out.println("9. 보험 수정한다");
        System.out.println("10. 고객 정보 조회");
        System.out.println("11. 직원 정보 조회");
        System.out.println("12. 계약 정보 조회");
        System.out.println("13. 보험 가입 신청 내역 조회");
        System.out.println("x. Exit");
    }

    public static void claimInsurance() throws IOException, CustomException {
        System.out.println("가입자의 아이디와 보험 아이디를 입력해주세요");
        System.out.print("고객 아이디 : ");
        String customerId = br.readLine().trim();
        System.out.print("보험 아이디 : ");
        String insuranceId = br.readLine().trim();

        Contract contract = contractList.getContractByID(customerId + insuranceId);
        if (contract != null) {
            System.out.println("계약 정보:");
            System.out.println("보험 이름: " + contract.getInsurance().getInsuranceName());
            System.out.println("고객 이름: " + contract.getCustomer().getCustomerName());
            System.out.println("전화번호: " + contract.getCustomer().getPhoneNumber());

            System.out.println("\n금액을 청구하시겠습니까?");
            System.out.print("Y / N : ");
            String yN = br.readLine().trim();
            if (yN.equalsIgnoreCase("Y")) {
                processClaim(contract);
            } else {
                System.out.println("금액 청구가 취소되었습니다.");
            }
        } else {
            System.out.println("해당 고객 정보를 찾을 수 없습니다.");
        }
    }

    public static void processClaim(Contract contract) throws IOException, CustomException {
        System.out.println("청구 정보를 입력해주세요.");

        System.out.print("접수자 이름: ");
        String claimantName = br.readLine().trim();
        System.out.print("접수자 전화번호: ");
        String claimantPhone = br.readLine().trim();
        System.out.print("업체명: ");
        String partnerName = br.readLine().trim();
        System.out.print("청구 서류: ");
        String claimDocument = br.readLine().trim();
        System.out.print("은행: ");
        String bank = br.readLine().trim();
        System.out.print("계좌번호: ");
        String accountNumber = br.readLine().trim();
        System.out.print("예금주명: ");
        String accountHolder = br.readLine().trim();

        if (claimantName.isEmpty() || claimantPhone.isEmpty() || partnerName.isEmpty() ||
                claimDocument.isEmpty() || bank.isEmpty() || accountNumber.isEmpty() || accountHolder.isEmpty()) {
            System.out.println("누락된 정보가 존재합니다.");
            return;
        }

        //내부 클래스에서 예외 시 Throw 사용
        partnerList.getPartnerByName(partnerName);

        CompensationClaim compensationClaim = new CompensationClaim(contract.getCustomer().getCustomerID(), claimantName, claimDocument,
                contract.getInsurance().getInsuranceID(), contract.getInsurance().getInsuranceName());

        compensationClaimList.add(compensationClaim);
        System.out.println("\n청구가 완료되었습니다.");
    }

    public static void queryInsurance() throws IOException, CustomException {
        System.out.println("보험 조회를 처리합니다.");

        //보험 정보 출력
        for (Insurance insurance : insuranceList.get()) {
            System.out.println(insurance.getInsuranceID() + " / " + insurance.getInsuranceName() + " / " + insurance.getPaymentAmount() + " / " + insurance.getCompensationAmount() +"\n");
        }
        System.out.println("조회를 원하는 보험 ID를 입력해주세요 : ");
        String userChoice = br.readLine().trim();
        Insurance seletedInsurance = insuranceList.getInsuranceByID(userChoice);

        System.out.println(seletedInsurance.toString());
        System.out.println("메인 화면으로 돌아가려면 x를, 보험을 신청하시려면 보험 ID를 입력해주세요: ");
        userChoice = br.readLine().trim();

        if (userChoice.equals("x")) return;

        System.out.println("고객 ID를 입력해주세요");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);

        //신청 완료된 경우
        // 현재 날짜와 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        // 포맷 설정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 포맷된 현재 날짜와 시간 문자열로 변환
        String formattedNow = now.format(formatter);
        TempContract tempContract = new TempContract(tempContractIndex++, customer.getCustomerID() ,seletedInsurance.getInsuranceID(), formattedNow);
        tempContractList.add(tempContract);
        System.out.println("신청이 완료되었습니다.");
    }

    public static void checkMyInsurance() throws IOException, CustomException {
        System.out.println("아이디를 입력해 주세요.");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);

        System.out.println(customer.getName() + " 님 확인 되었습니다.");
        System.out.println(customer.getName() + "님의 보험 리스트 입니다.");
        for (Contract contract : contractList.getContractList()) {
            if (contract.getCustomer().getCustomerID().equals(customerId))
                System.out.println("계약 ID = " + contract.getContractID() + "\n" +
                        "보험 ID = " + contract.getInsurance().getInsuranceID() + "\n" +
                        "보험 이름 = " + contract.getInsurance().getInsuranceName() + "\n" +
                        "보험료 = " + contract.getInsurance().getPaymentAmount() + "\n" +
                        "보상금 = " + contract.getInsurance().getCompensationAmount());

        }
        System.out.print("선택할 계약 번호를 입력하세요: ");
        String choice = br.readLine().trim();
        Contract contract = contractList.getContractByID(choice);

        System.out.println("보험 ID = " + contract.getInsurance().getInsuranceID() + "\n" +
                "보험 이름 = " + contract.getInsurance().getInsuranceName() + "\n" +
                "보험료 = " + contract.getInsurance().getPaymentAmount() + "\n" +
                "보상금 = " + contract.getInsurance().getCompensationAmount() + "\n" +
                "갱신 상태 = " + contract.getInsurance().getCycleType() + "\n" +
                "갱신 주기 = " + contract.getInsurance().getPaymentCycle() + "\n" +
                "보험 기간 = " + contract.getInsurance().getInsurancePeriod());
        System.out.println("해지하시겠습니까? Y/N");
        choice = br.readLine().trim();
        if (choice.equals("N")) return;
        printCancelInfo();
        choice = br.readLine().trim();
        if (choice.equals("N")) return;
        System.out.println("필요 서류를 입력해주세요:");
        System.out.print("보험 해지 신청서 (서명 필수): ");
        String applicationForm = br.readLine();
        System.out.print("신분증 사본: ");
        String idCopy = br.readLine();
        System.out.print("통장 사본 (환급금 수령을 위한 계좌 정보): ");
        String bankCopy = br.readLine();
        System.out.println("제출하시겠습니까?");
        System.out.println("[제출]");
        String submit = br.readLine().trim().toLowerCase();
        if (!submit.equals("제출")) System.out.println("제출이 취소되었습니다.");
        System.out.println("제출이 완료되었습니다.");
            //해지환급금이 있는 경우
        if (contract.getInsurance().getCycleType().equals("비갱신")) {
            System.out.println("===================================");
            System.out.println("      보험 해지 환급금 정보");
            System.out.println("===================================");
            System.out.println();
            System.out.println("해지 환급금 약관:");
            System.out.println("   - 해지 시점까지 납부한 보험료 중 일부 환급");
            System.out.println("   - 환급 금액: " + contract.calculateCancelMoney() + "원");
            System.out.println();
            System.out.println("===================================");
            System.out.println();
            System.out.println("요청하시겠습니까?");
            System.out.println();
            System.out.println("[요청]");

            String request = br.readLine().trim().toLowerCase();

            if (request.equals("요청")) System.out.println("요청이 완료되었습니다.");
            else System.out.println("요청이 취소되었습니다.");
        }

    }
    // ------------------checkMyInsurance 내부 함수들 ----------------------

    public static void printCancelInfo() {
        System.out.println("===================================");
        System.out.println("      보험 해지 약관 정보");
        System.out.println("===================================");
        System.out.println();
        System.out.println("1. 해지 조건:");
        System.out.println("   - 계약 기간이 최소 1년 이상 경과해야 합니다.");
        System.out.println("   - 미납 보험료가 없어야 합니다.");
        System.out.println();
        System.out.println("2. 수수료 및 패널티:");
        System.out.println("   - 해지 수수료: 보험료의 10%");
        System.out.println("   - 패널티: 잔여 계약 기간에 따라 추가 요금 부과 가능");
        System.out.println();
        System.out.println("3. 환급 규정:");
        System.out.println("   - 해지 시점까지 납부한 보험료 중 일부 환급");
        System.out.println("   - 환급 금액은 보험 계약서에 명시된 비율에 따름");
        System.out.println();
        System.out.println("4. 필요 서류 목록:");
        System.out.println("   - 보험 해지 신청서 (서명 필수)");
        System.out.println("   - 신분증 사본");
        System.out.println("   - 통장 사본 (환급금 수령을 위한 계좌 정보)");
        System.out.println();
        System.out.println("5. 해지 절차:");
        System.out.println("   - 고객센터 방문 또는 우편 접수");
        System.out.println("   - 필요 서류 제출");
        System.out.println("   - 해지 신청서 검토 및 승인 (3-5 영업일 소요)");
        System.out.println("   - 해지 완료 후 환급 절차 진행");
        System.out.println();
        System.out.println("6. 해지 후 보험효력:");
        System.out.println("   - 해지 완료 즉시 보험 효력 상실");
        System.out.println("   - 해지 후 발생한 사고에 대해서는 보상 불가");
        System.out.println();
        System.out.println("7. 고객 지원 정보:");
        System.out.println("   - 고객센터 전화: 1234-5678");
        System.out.println("   - 이메일: support@insurancecompany.com");
        System.out.println("   - 운영 시간: 월-금 09:00 - 18:00");
        System.out.println();
        System.out.println("===================================");
        System.out.println();
        System.out.println("해지하시겠습니까? Y/N");

    }
    // ------------------checkMyInsurance 내부 함수들 끝----------------------

    public static void fileComplaint() throws IOException {
        System.out.println("아이디를 입력하세요: ");String userID = br.readLine().trim();
        while(userID.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");userID = br.readLine().trim();}
        System.out.println("민원 내용을 입력하세요: ");String content = br.readLine().trim();
        while(content.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");content = br.readLine().trim();}
        Complaint complaint = new Complaint(userID, content);
        complaintList.add(complaint);
        System.out.println("접수가 완료되었습니다.");
    }
    public static void payInsurance() throws IOException, CustomException {
        System.out.println("고객 아이디를 입력해주세요");
        System.out.print("아이디 : ");
        String customerId = br.readLine().trim();

        // 2. 보험 정보 리스트와 버튼(납부) 출력
        System.out.println("보험 목록:");

        for (Contract contract : contractList.getContractList()) {
            if (contract.getCustomer().getCustomerID().equals(customerId)) {
                System.out.println("보험 ID: " + contract.getInsurance().getInsuranceID() + ", 보험 이름: " + contract.getInsurance().getInsuranceName()
                        + ", 보험료: " + contract.getInsurance().getPaymentAmount());
            }
        }

        // 3. 납부를 원하는 보험 조회
        System.out.println("\n납부를 원하는 보험의 아이디를 입력하세요: ");
        String insuranceId = br.readLine().trim();

        Contract contract = contractList.getContractByID(customerId + insuranceId);

        System.out.println("보험명: " + contract.getInsurance().getInsuranceName() + ", 보험료: " + contract.getInsurance().getPaymentAmount());


        // 4. 납부 정보 입력창과 버튼(제출) 출력
        System.out.println("\n납부 정보를 입력하세요.");

        System.out.print("은행 이름: ");
        String bankName = br.readLine().trim();
        System.out.print("계좌번호: ");
        String accountNumber = br.readLine().trim();
        System.out.print("예금주명: ");
        String accountHolder = br.readLine().trim();

        Payment payment = new Payment(contract.getCustomer().getCustomerID(), contract.getInsurance().getInsuranceID(), contract.getInsurance().getPaymentAmount(), bankName, accountNumber, accountHolder);
        contract.getPaymentList().add(payment);
        // 6. 납부 완료 메시지 출력
        System.out.println("\n납부가 완료되었습니다.");
    }

    public static void queryPartnerCompanies() throws IOException, CustomException {
        for (Partner partner : partnerList.get()) {
            System.out.println(partner.getPartnerName() + " / "  + partner.getPartnerType());
        }
        System.out.println("업체를 등록하려면 \"등록\"을, 세부 조회를 하려면 업체명을 입력해주세요.");
        String userInput = br.readLine().trim();
        if (userInput.equals("등록")) {
            System.out.println("업체명을 입력하세요: ");String partnerName = br.readLine().trim();
            while(partnerName.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");partnerName = br.readLine().trim();}
            System.out.println("업종을 입력하세요: ");String partnerType = br.readLine().trim();
            while(partnerType.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");partnerType = br.readLine().trim();}
            System.out.println("주소를 입력하세요: ");String partnerAddress = br.readLine().trim();
            while(partnerAddress.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");partnerAddress = br.readLine().trim();}
            System.out.println("전화번호를 입력하세요: ");String partnerPhoneNumber = br.readLine().trim();
            while(partnerPhoneNumber.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");partnerPhoneNumber = br.readLine().trim();}
            Partner partner = new Partner(partnerName, partnerType, partnerAddress, partnerPhoneNumber);
            partnerList.add(partner);
            System.out.println("저장이 완료되었습니다.");
        } else {
            Partner selectedPartner = partnerList.getPartnerByName(userInput);
            System.out.println(selectedPartner.getPartnerName() + " / " + selectedPartner.getPartnerType()
                    + " / " + selectedPartner.getPartnerAddress() + " / " + selectedPartner.getPartnerPhoneNumber());
            System.out.println("업체를 평가하시겠습니까? (Y/N): ");
            userInput = br.readLine().trim();
            if(userInput.equals("Y")) {
                System.out.println("평가자 이름을 입력해주세요: ");
                String employeeName = br.readLine().trim();
                while(employeeName.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");employeeName = br.readLine().trim();}
                System.out.println("평점을 입력해주세요: ");
                String rates = br.readLine().trim();
                while(rates.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");rates = br.readLine().trim();}
                System.out.println("평가 내용을 입력해주세요: ");
                String content = br.readLine().trim();
                while(content.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");content = br.readLine().trim();}

                Rate rate = new Rate(employeeName, Integer.parseInt(rates), content);
                selectedPartner.getRateList().add(rate);
                System.out.println("평가가 완료되었습니다.");
            }
        }
    }
    public static void assessDamage() throws IOException, CustomException {
        for (CompensationClaim compensationClaim : compensationClaimList.get()) {
            System.out.println(compensationClaim.getContractID() + " / " + compensationClaim.getInsuranceName()
                    +  " / " + compensationClaim.getClaimantName());
        }
        System.out.println("손해 사정을 하려면 \"손해 사정\"을, 보상금 요청을 하려면 \"보상금 요청\"을 입력하세요: ");
        String userInput = br.readLine().trim();
        if(userInput.equals("손해 사정")) {
            System.out.println("손해 사정할 계약 ID를 입력하세요: ");
            String contractID = br.readLine().trim();
            Contract contract = contractList.getContractByID(contractID);
            System.out.println("직원 이름을 입력해주세요: ");
            String managerName = br.readLine();
            while(managerName.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");managerName = br.readLine().trim();}
            System.out.println("청구 서류를 제출해주세요: ");
            String documentFile = br.readLine();
            while(documentFile.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");documentFile = br.readLine().trim();}
            System.out.println("청구 금액을 입력해주세요: ");
            String compensationClaimAmount = br.readLine();
            while(compensationClaimAmount.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");compensationClaimAmount = br.readLine().trim();}
            System.out.println("면/부책 사유를 입력해주세요: ");
            String reason = br.readLine();
            while(reason.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");reason = br.readLine().trim();}
            System.out.println("총 보상금을 입력해주세요: ");
            String surveyAmount = br.readLine();
            while(surveyAmount.isEmpty()){System.out.println("입력 정보가 누락되었습니다. 다시 입력해주세요: ");surveyAmount = br.readLine().trim();}
            for (CompensationClaim compensationClaim : compensationClaimList.get()) {
                if(contractID.equals(contract.getContractID())) {
                    compensationClaim.setSurvey(new Survey(contract.getCustomer().getCustomerID(), contract.getInsurance().getInsuranceID(), managerName, Integer.parseInt(surveyAmount), reason));
                    break;
                }
            }
            System.out.println("저장이 완료되었습니다.");

        } else if (userInput.equals("보상금 요청")) {
            System.out.println("보상금을 요청할 계약 ID를 입력하세요: ");
            String contractID = br.readLine().trim();
            CompensationClaim compensationClaim = compensationClaimList.getCompensationClaimByID(contractID);

            System.out.println(compensationClaim.getSurvey().getManagerName()
                    + " / " + compensationClaim.getDocumentFile()
                    + " / " + compensationClaim.getSurvey().getReason()
                    + " / " + compensationClaim.getSurvey().getSurveyAmount());
            System.out.println("보상금 요청을 완료하려면 엔터를 눌러주세요");
            br.readLine().trim();
            System.out.println("요청이 완료되었습니다.");
        }
    }
    public static void registerInsurance() throws IOException {
        System.out.println("보험 등록을 처리합니다.\n");

        System.out.println("보험종류");
        System.out.println("1. 일반보험 || 2. 건강보험 || 3. 자동차보험 || 4. 여행자보험");
        System.out.println("등록하실 보험 종류의 숫자를 입력해주세요");
        int insuranceType = Integer.parseInt(br.readLine().trim());

        System.out.print("보험 이름: ");
        String insuranceName = br.readLine().trim();

        System.out.print("보험료: ");
        int paymentAmount = Integer.parseInt(br.readLine().trim());

        System.out.print("보상금: ");
        int compensationAmount = Integer.parseInt(br.readLine().trim());

        System.out.print("갱신 상태 (자동갱신/비갱신): ");
        String cycleType = br.readLine().trim();
        String paymentCycle = "";
        if (cycleType.equals("자동갱신")) {
            System.out.print("갱신 주기: ");
            paymentCycle = br.readLine().trim();
        } else {
            paymentCycle = "0";
        }

        System.out.print("보험 기간: ");
        String insurancePeriod = br.readLine().trim();

        Insurance insurance = new Insurance(compensationAmount, cycleType, insuranceName, Integer.toString(insuranceIndex++),
                paymentAmount, paymentCycle, insurancePeriod);

        switch (insuranceType) {
            case 1:
                insuranceList.add(insurance);
                System.out.println("\n신규 보험 등록이 완료되었습니다.");
                break;
            case 2:
                registerHealthInsurance(insurance);
                System.out.println("\n신규 보험 등록이 완료되었습니다.");
                break;
            case 3:
                registerCarInsurance(insurance);
                System.out.println("\n신규 보험 등록이 완료되었습니다.");
                break;
            case 4:
                registerTravelInsurance(insurance);
                System.out.println("\n신규 보험 등록이 완료되었습니다.");
                break;
        }

    }

    private static void registerHealthInsurance(Insurance insurance) throws IOException {
        System.out.print("보장 질환 목록 (쉼표로 구분하여 입력하세요): ");
        String[] diseases = br.readLine().trim().split(",");
        ArrayList<String> diseaseList = new ArrayList<>(Arrays.asList(diseases));

        Insurance healthInsurance = new HealthInsurance(insurance, diseaseList);
        insuranceList.add(healthInsurance);
    }

    private static void registerCarInsurance(Insurance insurance) throws IOException {
        System.out.print("자동차 종류: ");
        String carModel = br.readLine().trim();

        Insurance carInsurance = new CarInsurance(insurance, carModel);

        insuranceList.add(carInsurance);
    }

    private static void registerTravelInsurance(Insurance insurance) throws IOException {
        System.out.print("국가명: ");
        String countryName = br.readLine().trim();

        Insurance travelInsurance = new TravelInsurance(insurance, countryName);
        insuranceList.add(travelInsurance);
    }

//    public static void modifyInsurance() throws IOException, CustomException {
//        System.out.println("보험 수정을 처리합니다.\n");
//
//        System.out.println("보험 종류를 선택하세요.");
//        System.out.println("1. 일반보험 || 2. 건강보험 || 3. 자동차보험 || 4. 여행자보험");
//        System.out.println("등록하실 보험 종류의 숫자를 입력해주세요.");
//        int insuranceType = Integer.parseInt(br.readLine().trim());
//
//        // 2. 보험 이름 입력창 출력
//        System.out.print("보험 이름을 입력하세요: ");
//        String insuranceName = br.readLine().trim();
//
//        // 3. 해당 정보를 입력 후 조회
//        Insurance insurance = insuranceList.getInsuranceByName(insuranceName);
//
//        // 4. 해당 보험의 정보 수정창 출력
//        System.out.println("현재 보험 정보:");
//        System.out.println(insurance.toString());
//
//        System.out.println("\n새로운 정보를 입력하세요 (변경하지 않으려면 Enter 키를 누르세요):");
//
//        // 5. 정보 수정 입력
//        System.out.print("보험 이름 (" + insurance.getInsuranceName() + "): ");
//        String newInsuranceName = br.readLine().trim();
//        if (!newInsuranceName.isEmpty()) {
//            insurance.setInsuranceName(newInsuranceName);
//        }
//
//        System.out.print("보험료 (" + insurance.getPaymentAmount() + "): ");
//        String newInsurancePremiumStr = br.readLine().trim();
//        if (!newInsurancePremiumStr.isEmpty()) {
//            int newInsurancePremium = Integer.parseInt(newInsurancePremiumStr);
//            insurance.setPaymentAmount(newInsurancePremium);
//        }
//
//        System.out.print("보상금 (" + insurance.getCompensationAmount() + "): ");
//        String newCompensationAmountStr = br.readLine().trim();
//        if (!newCompensationAmountStr.isEmpty()) {
//            int newCompensationAmount = Integer.parseInt(newCompensationAmountStr);
//            insurance.setCompensationAmount(newCompensationAmount);
//        }
//
//        System.out.print("갱신 상태 (" + insurance.getCycleType() + "): ");
//        String newRenewalStatus = br.readLine().trim();
//        if (!newRenewalStatus.isEmpty()) {
//            insurance.setCycleType(newRenewalStatus);
//        }
//
//        System.out.print("갱신 주기 (" + insurance.getPaymentCycle() + "): ");
//        String newRenewalCycle = br.readLine().trim();
//        if (!newRenewalCycle.isEmpty()) {
//            insurance.setPaymentCycle(newRenewalCycle);
//        }
//
//        System.out.print("보험 기간 (" + insurance.getInsurancePeriod() + "): ");
//        String newInsurancePeriod = br.readLine().trim();
//        if (!newInsurancePeriod.isEmpty()) {
//            insurance.setInsurancePeriod(newInsurancePeriod);
//        }
//
//        System.out.println("\n수정이 완료되었습니다.");
//    }

    public static void modifyInsurance() throws IOException, CustomException {
        System.out.println("보험 수정을 처리합니다.\n");

        System.out.print("보험 이름을 입력하세요: ");
        String insuranceName = br.readLine().trim();

        // 해당 정보를 입력 후 조회
        Insurance insurance = insuranceList.getInsuranceByName(insuranceName);

        // 보험 종류를 확인하여 사용자에게 출력
        System.out.println("해당 보험은 다음과 같은 종류입니다: ");
        if (insurance instanceof HealthInsurance) {
            System.out.println("2. 건강보험");
        } else if (insurance instanceof CarInsurance) {
            System.out.println("3. 자동차보험");
        } else if (insurance instanceof TravelInsurance) {
            System.out.println("4. 여행자보험");
        } else {
            System.out.println("1. 일반보험");
        }

        System.out.println("\n현재 보험 정보:");
        System.out.println(insurance.toString());

        System.out.println("\n새로운 정보를 입력하세요 (변경하지 않으려면 Enter 키를 누르세요):");

        System.out.print("보험 이름 (" + insurance.getInsuranceName() + "): ");
        String newInsuranceName = br.readLine().trim();
        if (!newInsuranceName.isEmpty()) {
            insurance.setInsuranceName(newInsuranceName);
        }

        System.out.print("보험료 (" + insurance.getPaymentAmount() + "): ");
        String newInsurancePremiumStr = br.readLine().trim();
        if (!newInsurancePremiumStr.isEmpty()) {
            int newInsurancePremium = Integer.parseInt(newInsurancePremiumStr);
            insurance.setPaymentAmount(newInsurancePremium);
        }

        System.out.print("보상금 (" + insurance.getCompensationAmount() + "): ");
        String newCompensationAmountStr = br.readLine().trim();
        if (!newCompensationAmountStr.isEmpty()) {
            int newCompensationAmount = Integer.parseInt(newCompensationAmountStr);
            insurance.setCompensationAmount(newCompensationAmount);
        }

        System.out.print("갱신 상태 (" + insurance.getCycleType() + "): ");
        String newRenewalStatus = br.readLine().trim();
        if (!newRenewalStatus.isEmpty()) {
            insurance.setCycleType(newRenewalStatus);
        }

        System.out.print("갱신 주기 (" + insurance.getPaymentCycle() + "): ");
        String newRenewalCycle = br.readLine().trim();
        if (!newRenewalCycle.isEmpty()) {
            insurance.setPaymentCycle(newRenewalCycle);
        }

        System.out.print("보험 기간 (" + insurance.getInsurancePeriod() + "): ");
        String newInsurancePeriod = br.readLine().trim();
        if (!newInsurancePeriod.isEmpty()) {
            insurance.setInsurancePeriod(newInsurancePeriod);
        }

        // 보험 종류에 따른 수정 메서드 호출
        if (insurance instanceof HealthInsurance) {
            modifyHealthInsurance((HealthInsurance) insurance);
        } else if (insurance instanceof CarInsurance) {
            modifyCarInsurance((CarInsurance) insurance);
        } else if (insurance instanceof TravelInsurance) {
            modifyTravelInsurance((TravelInsurance) insurance);
        }

        System.out.println("\n수정이 완료되었습니다.");
    }

    private static void modifyHealthInsurance(HealthInsurance insurance) throws IOException {
        System.out.print("보장 질환 목록 (" + insurance.getDiseaseList() + "): ");
        String newDiseaseListStr = br.readLine().trim();
        if (!newDiseaseListStr.isEmpty()) {
            String[] diseases = newDiseaseListStr.split(",");
            ArrayList<String> diseaseList = new ArrayList<>(Arrays.asList(diseases));
            insurance.setDiseaseList(diseaseList);
        }
    }

    private static void modifyCarInsurance(CarInsurance insurance) throws IOException {
        System.out.print("자동차 종류 (" + insurance.getModel() + "): ");
        String newCarModel = br.readLine().trim();
        if (!newCarModel.isEmpty()) {
            insurance.setModel(newCarModel);
        }
    }

    private static void modifyTravelInsurance(TravelInsurance insurance) throws IOException {
        System.out.print("국가명 (" + insurance.getCountryName() + "): ");
        String newCountryName = br.readLine().trim();
        if (!newCountryName.isEmpty()) {
            insurance.setCountryName(newCountryName);
        }
    }


    public static void queryCustomerInfo() throws IOException, CustomException{
        System.out.println("고객 정보 조회를 처리합니다.");
        System.out.println("1. 고객 정보 조회");
        System.out.println("2. 고객 정보 등록");
        System.out.println("3. 고객 정보 수정");
        System.out.print("메뉴를 선택하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());

        switch (choice) {
            case 1:
                viewCustomerInfo();
                break;
            case 2:
                registerCustomerInfo();
                break;
            case 3:
                modifyCustomerInfo();
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }

    }

    //---------------queryCustomerInfo 내부 함수들 ----------------
    public static void registerCustomerInfo() throws IOException {
        FamilyHistoryImpl familyHistoryList = new FamilyHistoryImpl();
        PersonalHistoryImpl personalHistoryList = new PersonalHistoryImpl();

        System.out.println("고객 정보를 등록합니다.");
        System.out.print("아이디: ");
        String id = br.readLine().trim();
        System.out.print("이름: ");
        String name = br.readLine().trim();
        System.out.print("성별: ");
        String gender = br.readLine().trim();
        System.out.print("생년월일: ");
        String birth = br.readLine().trim();
        System.out.print("전화번호: ");
        String phoneNumber = br.readLine().trim();
        System.out.print("이메일: ");
        String email = br.readLine().trim();
        System.out.print("주소: ");
        String address = br.readLine().trim();
        System.out.print("직업: ");
        String job = br.readLine().trim();

        while (true) {
            System.out.println("가족력을 입력해주세요 (없을 경우 X를 입력해주세요)");
            System.out.print("질병명: ");
            String diseaseName = br.readLine().trim();
            if (diseaseName.equals("X")) break;
            System.out.print("가족관계: ");
            String relationship = br.readLine().trim();

            FamilyHistory familyHistory = new FamilyHistory(diseaseName, relationship);
            familyHistoryList.add(familyHistory);
        }

        while (true) {
            System.out.println("개인병력을 입력해주세요 (없을 경우 X를 입력해주세요)");
            System.out.print("질병명: ");
            String diseaseName = br.readLine().trim();
            if (diseaseName.equals("X")) break;
            System.out.print("발병시기: ");
            String occurDate = br.readLine().trim();

            PersonalHistory personalHistory = new PersonalHistory(diseaseName, occurDate);
            personalHistoryList.add(personalHistory);
        }


        Customer newCustomer = new Customer(id, name, gender, birth, phoneNumber, email,
                address, job, familyHistoryList, personalHistoryList);
        customerList.add(newCustomer);
        System.out.println("고객 정보가 등록되었습니다.");
    }

    public static void modifyCustomerInfo() throws IOException, CustomException {
        System.out.println("고객 정보를 수정합니다.");
        System.out.print("수정할 고객 ID: ");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);

        System.out.println("\n새로운 정보를 입력하세요 (변경하지 않으려면 Enter 키를 누르세요):");
        System.out.print("이름 (" + customer.getName() + "): ");
        String name = br.readLine().trim();
        if (!name.isEmpty()) customer.setName(name);
        System.out.print("성별 (" + customer.getGender() + "): ");
        String gender = br.readLine().trim();
        if (!gender.isEmpty()) customer.setGender(gender);
        System.out.print("생년월일 (" + customer.getBirth() + "): ");
        String birth = br.readLine().trim();
        if (!birth.isEmpty()) customer.setBirth(birth);
        System.out.print("전화번호 (" + customer.getPhoneNumber() + "): ");
        String phoneNumber = br.readLine().trim();
        if (!phoneNumber.isEmpty()) customer.setPhoneNumber(phoneNumber);
        System.out.print("이메일 (" + customer.getEmail() + "): ");
        String email = br.readLine().trim();
        if (!email.isEmpty()) customer.setEmail(email);
        System.out.print("주소 (" + customer.getAddress() + "): ");
        String address = br.readLine().trim();
        if (!address.isEmpty()) customer.setAddress(address);
        System.out.print("직업 (" + customer.getJob() + "): ");
        String job = br.readLine().trim();
        if (!job.isEmpty()) customer.setJob(job);
        System.out.println("수정이 완료되었습니다.");
    }

    private static void viewCustomerInfo() throws IOException, CustomException {
        for (Customer customer : customerList.get()) {
            System.out.println(customer.getCustomerID() + " / " + customer.getName() + " / " + customer.getPhoneNumber());
        }
        System.out.print("조회할 고객 ID를 입력해주세요: ");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);
        System.out.println(customer.toString());
    }
    //---------------queryCustomerInfo 내부 함수들 끝----------------

    public static void queryEmployeeInfo() throws IOException, CustomException{
        System.out.println("직원 정보 조회를 처리합니다.");
        System.out.println("1. 직원 정보 조회");
        System.out.println("2. 직원 정보 등록");
        System.out.println("3. 직원 정보 수정");
        System.out.print("메뉴를 선택하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());

        switch (choice) {
            case 1:
                viewEmployeeInfo();
                break;
            case 2:
                registerEmployeeInfo();
                break;
            case 3:
                modifyEmployeeInfo();
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }

    }
    public static void viewEmployeeInfo() throws IOException, CustomException {
        System.out.println("직원 정보 조회를 처리합니다.");
        for (Employee employee : employeeList.get()) {
            System.out.println(employee.getEmployeeID() + " / " + employee.getEmployeeName() + " / " + employee.getEmployeePhoneNumber());
        }
        System.out.println("상세 정보를 확인하려면 직원 ID를 입력하세요: ");
        String employeeID = br.readLine().trim();
        Employee employee = employeeList.getEmployeeByID(employeeID);

        System.out.println(employee.toString());
        System.out.println("판매 실적을 조회하려면 \"판매 실적 조회\"를 입력하세요.");
        String userInput = br.readLine().trim();
        if (userInput.equals("판매 실적 조회")) {
            for (SellingRecord sellingRecord : employee.getSellingRecordList().get()) {
                System.out.println(sellingRecord.getCustomerID() + " / " + sellingRecord.getInsuranceID() + " / " + sellingRecord.getContractDate());
            }
            System.out.println("판매 실적을 등록하려면 \"판매 실적 등록\"을 입력하세요.");
            userInput = br.readLine().trim();
            if (userInput.equals("판매 실적 등록")) {
                System.out.println("고객 ID를 입력하세요: ");
                String customerID = br.readLine();
                System.out.println("가입한 보험 ID를 입력하세요: ");
                String insuranceID = br.readLine();
                System.out.println("가입 일자를 입력하세요: ");
                String contractDate = br.readLine();
                System.out.println("등록을 완료하려면 엔터를 눌러주세요.");
                br.readLine();
                employee.getSellingRecordList().add(new SellingRecord(customerID, insuranceID, contractDate));
                System.out.println("등록이 완료되었습니다.");
            }
        }
    }

    public static void registerEmployeeInfo() throws IOException {
        System.out.println("직원 정보를 등록합니다.");
        System.out.print("아이디: ");
        String id = br.readLine().trim();
        System.out.print("이름: ");
        String name = br.readLine().trim();
        System.out.print("성별: ");
        String gender = br.readLine().trim();
        System.out.print("생년월일: ");
        String birth = br.readLine().trim();
        System.out.print("연락처: ");
        String phoneNumber = br.readLine().trim();
        System.out.print("직급: ");
        String position = br.readLine().trim();
        System.out.print("주소: ");
        String address = br.readLine().trim();
        System.out.print("입사날짜: ");
        String incidentDate = br.readLine().trim();

        Employee employee = new Employee(id, name, gender, birth, phoneNumber, position,
                address, incidentDate);
        employeeList.add(employee);
        System.out.println("고객 정보가 등록되었습니다.");
    }

    public static void modifyEmployeeInfo() throws IOException, CustomException {
        System.out.println("직원 정보를 수정합니다.");
        System.out.print("수정할 직원 ID: ");
        String customerId = br.readLine().trim();
        Employee employee = employeeList.getEmployeeByID(customerId);

        System.out.println("\n새로운 정보를 입력하세요 (변경하지 않으려면 Enter 키를 누르세요):");
        System.out.print("직원 ID (" + employee.getEmployeeID() + "): ");
        String id = br.readLine().trim();
        if (!id.isEmpty()) employee.setEmployeeID(id);

        System.out.print("이름 (" + employee.getEmployeeName() + "): ");
        String name = br.readLine().trim();
        if (!name.isEmpty()) employee.setEmployeeName(name);

        System.out.print("성별 (" + employee.getGender() + "): ");
        String gender = br.readLine().trim();
        if (!gender.isEmpty()) employee.setGender(gender);

        System.out.print("생년월일 (" + employee.getBirth() + "): ");
        String birth = br.readLine().trim();
        if (!birth.isEmpty()) employee.setBirth(birth);

        System.out.print("직급 (" + employee.getPosition() + "): ");
        String position = br.readLine().trim();
        if (!position.isEmpty()) employee.setPosition(position);

        System.out.print("주소 (" + employee.getAddress() + "): ");
        String address = br.readLine().trim();
        if (!address.isEmpty()) employee.setAddress(address);

        System.out.print("입사날짜 (" + employee.getIncidentDate() + "): ");
        String hireDate = br.readLine().trim();
        if (!hireDate.isEmpty()) employee.setIncidentDate(hireDate);

        System.out.print("연락처 (" + employee.getEmployeePhoneNumber() + "): ");
        String contact = br.readLine().trim();
        if (!contact.isEmpty()) employee.setEmployeePhoneNumber(contact);
        System.out.println("수정이 완료되었습니다.");
    }

    public static void queryContractInfo() throws IOException, CustomException{

        System.out.println("계약 정보 조회를 처리합니다.");
        viewContract();

        System.out.println("1. 갱신 요청한다.");
        System.out.println("2. 납부 요청한다.");
        System.out.print("선택할 번호를 입력하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());
        switch (choice) {
            case 1:
                renewContract();
                break;
            case 2:
                requestPayment();
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }
    }

    //-------------------queryContractInfo 내부 함수들--------------------


    public static void renewContract() throws IOException, CustomException {
        System.out.println("계약 갱신을 요청합니다.");
        System.out.print("갱신할 계약 번호: ");
        String contractId = br.readLine().trim();
        Contract contract = contractList.getContractByID(contractId);

        System.out.println("갱신 요청이 완료되었습니다..");

    }
    public static void requestPayment() throws IOException, CustomException {
        System.out.println("납부 요청을 처리합니다.");
        System.out.print("납부할 계약 번호: ");
        String contractId = br.readLine().trim();
        Contract contract = contractList.getContractByID(contractId);

        System.out.println("납부 요청이 완료되었습니다..");

    }

    private static void viewContract() throws IOException {
        for (Contract contract: contractList.getContractList())
            System.out.println(contract.toString());
    }
    //-------------------queryContractInfo 내부 함수들 끝 --------------------

    public static void queryInsuranceApplication() throws IOException, CustomException {
        System.out.println("보험 가입 신청 내역 조회를 처리합니다.");
        System.out.println(tempContractList.getAllApplications());
        System.out.print("승인할 신청 ID: ");
        String applicationId = br.readLine().trim();
        TempContract application = tempContractList.getInsuranceApplicationById(applicationId);

        Customer customer = customerList.getCustomerByID(application.getCustomerId());
        Insurance insurance = insuranceList.getInsuranceByID(application.getInsuranceId());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        Contract contract = new Contract(customer, insurance, formattedNow);
        contractList.add(contract);
        System.out.println("보험 가입 신청이 승인되었습니다.");
    }
    //--------------------------queryInsuranceApplication 내부 함수들 끝------------------

    public static void createDummyDate() {
        //보험 등록
        Insurance insurance1 = new Insurance(500000, "비갱신","표준 플랜", Integer.toString(insuranceIndex++),
                50000,"0", "12");
        Insurance insurance2 = new Insurance(1000000, "비갱신", "고급 자동차 플랜", Integer.toString(insuranceIndex++),
                120000, "0", "24");
        Insurance carInsurance = new CarInsurance(insurance2, "G80");
        Insurance insurance3 = new Insurance(300000, "비갱신", "기본 여행 플랜", Integer.toString(insuranceIndex++),
                25000, "0", "36");
        Insurance travelInsurance = new TravelInsurance(insurance3, "일본");
        Insurance insurance4 = new Insurance(750000, "비갱신", "프리미엄 건강 플랜", Integer.toString(insuranceIndex++),
                80000, "0", "18");
        Insurance healthInsurance = new HealthInsurance(insurance4, new ArrayList<>(Arrays.asList("암", "관절염")));

        insuranceList.add(insurance1);
        insuranceList.add(carInsurance);
        insuranceList.add(travelInsurance);
        insuranceList.add(healthInsurance);

        //고객 등록
        FamilyHistoryImpl familyHistoryList = new FamilyHistoryImpl();
        PersonalHistoryImpl personalHistoryList = new PersonalHistoryImpl();

        FamilyHistory familyHistory = new FamilyHistory("대장암", "부");
        familyHistoryList.add(familyHistory);

        PersonalHistory personalHistory = new PersonalHistory("관절염", "2010-07-15");
        personalHistoryList.add(personalHistory);

        Customer customer1 = new Customer("1", "김철수", "남성", "1985-02-15", "010-1234-5678", "chulsoo@example.com", "서울시 강남구", "회사원", familyHistoryList, personalHistoryList);
        Customer customer2 = new Customer("2", "이영희", "여성", "1990-07-20", "010-2345-6789", "younghee@example.com", "부산시 해운대구", "디자이너", new FamilyHistoryImpl(), new PersonalHistoryImpl());

        customerList.add(customer1);
        customerList.add(customer2);

        //직원 등록
        Employee employee1 = new Employee("EMP001", "홍길동", "남성", "1980-01-15", "010-1234-5678", "매니저", "서울시 종로구", "2024-01-10");
        Employee employee2 = new Employee("EMP002", "김영희", "여성", "1992-06-20", "010-2345-6789", "개발자", "부산시 해운대구", "2024-01-15");

        employeeList.add(employee1);
        employeeList.add(employee2);
    }
}
