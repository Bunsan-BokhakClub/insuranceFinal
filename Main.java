import customer.Customer;
import customer.CustomerListImpl;
import insurance.Insurance;
import insurance.InsuranceApplication.InsuranceApplication;
import insurance.InsuranceListImpl;
import compensation.CompensationClaim;
import compensation.CompensationClaimListImpl;
import compensation.Servey;
import contract.Contract;
import contract.ContractListImpl;
import insurance.*;
import partner.Partner;
import partner.PartnerListImpl;
import payment.Payment;
import payment.PaymentListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



  

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int insuranceIndex = 1;
    private static List<Contract> contracts = new ArrayList<>();

    private static List<InsuranceApplication> insuranceApplications = new ArrayList<>(); // 보험 가입 신청 내역을 저장하는 리스트


    private static ContractListImpl contractList;
    private static PartnerListImpl partnerList;
    private static CompensationClaimListImpl compensationClaimList;
    private static InsuranceListImpl insuranceList;
    private static PaymentListImpl paymentList;


    public static void main(String[] args) throws IOException {
        ArrayList<Insurance> insList = new ArrayList<>();
        insuranceList = new InsuranceListImpl(insList);

        ArrayList<Contract> conList = new ArrayList<>();
        contractList = new ContractListImpl(conList);

        ArrayList<Partner> partList = new ArrayList<>();
        partnerList = new PartnerListImpl(partList);

        ArrayList<CompensationClaim> compList = new ArrayList<>();
        compensationClaimList = new CompensationClaimListImpl(compList);

        ArrayList<Payment> payList = new ArrayList<>();
        paymentList = new PaymentListImpl(payList);

        String userChoice = "";
        while (!userChoice.equals("x")) {
            showMenu();
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
    }

    public static void claimInsurance() throws IOException {
        System.out.println("보상금 청구를 처리합니다.\n");

        System.out.println("가입자의 성함과 전화번호를 입력해주세요");
        System.out.print("성함 : ");
        String name = br.readLine().trim();
        System.out.print("전화번호 : ");
        String pN = br.readLine().trim();

        Contract contract = contractList.getContractByNameAndPN(name, pN);
        if (contract != null) {
            System.out.println("계약 정보:");
            System.out.println("보험 이름: " + contract.getInsuranceName());
            System.out.println("고객 이름: " + contract.getCustomerName());
            System.out.println("전화번호: " + contract.getPhoneNumber());

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

    public static void processClaim(Contract contract) throws IOException {
        System.out.println("청구 정보를 입력해주세요.");

        System.out.print("접수자 이름: ");
        String claimantName = br.readLine().trim();
        System.out.print("접수자 전화번호: ");
        String claimantPhone = br.readLine().trim();
        System.out.print("업체명: ");
        String partnerName = br.readLine().trim();
        System.out.print("청구 금액: ");
        int claimValue = Integer.parseInt(br.readLine().trim());
        System.out.print("청구 서류: ");
        String claimDocument = br.readLine().trim();
        System.out.print("은행: ");
        String bank = br.readLine().trim();
        System.out.print("계좌번호: ");
        String accountNumber = br.readLine().trim();
        System.out.print("예금주명: ");
        String accountHolder = br.readLine().trim();

        Partner partner = partnerList.getPartnerByName(partnerName);
        Servey servey = new Servey(claimantName, bank, accountNumber,accountHolder, claimValue, partner);
        CompensationClaim compensationClaim = new CompensationClaim(contract.getCustomerID(), contract.getCustomerName(), claimDocument,
                contract.getInsuranceID(), contract.getInsuranceName(), servey);

        if(partner != null) {
            compensationClaimList.add(compensationClaim);
            System.out.println("\n청구가 완료되었습니다.");
        } else {
            System.out.println("\n 청구에 실패하였습니다. 다시 시도해주세요.");
        }
    }

    public static void queryInsurance() {
        System.out.println("보험 조회를 처리합니다.");
    }

    public static void checkMyInsurance() throws IOException {
        System.out.println("아이디를 입력해 주세요.");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);
        if (customer != null) {
            System.out.println(customer.getName() + " 님 확인 되었습니다.");
            System.out.println(customer.getName() + "님의 보험 리스트 입니다.");
            List<Insurance> insurances = insuranceListImpl.getListByUserId(customer.getCustomerID());
            if (insurances.isEmpty()) {
                System.out.println("가입한 보험이 없습니다.");
                return;
            }
            for (int i = 0; i < insurances.size(); i++) {
                System.out.println((i + 1) + ". 보험 ID: " + insurances.get(i).getInsuranceID() + ", 보험 이름: " + insurances.get(i).getInsuranceName());
            }
            System.out.print("선택할 보험 번호를 입력하세요: ");
            int choice = Integer.parseInt(br.readLine().trim()) - 1;
            if (choice >= 0 && choice < insurances.size()) {
                Insurance selectedInsurance = insurances.get(choice);
                System.out.println("선택한 보험: " + selectedInsurance.getInsuranceName());
                System.out.println("1. 보험 해지");
                System.out.print("선택할 번호를 입력하세요: ");
                int actionChoice = Integer.parseInt(br.readLine().trim());

                if (actionChoice == 1) {
                    cancelInsurance(selectedInsurance, customer);
                    System.out.println("1. 환급금 지급 요청");
                    System.out.print("선택할 번호를 입력하세요: ");
                    int refundChoice = Integer.parseInt(br.readLine().trim());
                    if (refundChoice == 1) {
                        requestRefund(selectedInsurance);
                    } else {
                        System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
                    }
                } else {
                    System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
                }
            } else {
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
            }
        } else {
            System.out.println("일치하는 아이디가 없습니다.");
            checkMyInsurance();
        }
    }
    // ------------------checkMyInsurance 내부 함수들 ----------------------
    public static void cancelInsurance(Insurance insurance, Customer customer) {
        System.out.println("해당 보험을 해지하시면 다음과 같은 패널티가 부과될 수 있습니다.");
        System.out.println("패널티 : 계약금의 80프로만 지급");
        //어떤 패널티가 있는지 확인하는 부분 나중에 추가해서 수정해야함.

        System.out.println("보험 ID: " + insurance.getInsuranceID() + "가 해지되었습니다.");
        insuranceListImpl.delete(insurance.getInsuranceID());
        List<Contract> customerContracts = new ArrayList<>();
        for (Contract contract : contracts) {
            if (contract.getCustomerID().equals(customer.getCustomerID()) && contract.getInsuranceID().equals(insurance.getInsuranceID())) {
                customerContracts.add(contract);
            }
        }
        contracts.removeAll(customerContracts);

    }
    // ------------------checkMyInsurance 내부 함수들 끝----------------------


    public static void requestRefund(Insurance insurance) {
        System.out.println("보험 ID: " + insurance.getInsuranceID() + "에 대한 환급금 지급 요청이 처리되었습니다.");

        int refundAmount = calculateRefund(insurance);
        System.out.println("환급금: " + refundAmount + "원이 지급될 예정입니다.");
    }
    private static int calculateRefund(Insurance insurance) {
        return (int) (insurance.getPaymentAmount() * 0.8); // 예시: 납입 금액의 80% 환급
    }

    public static void fileComplaint() {
        System.out.println("민원 접수를 처리합니다.");
    }

    public static void payInsurance() throws IOException {
        System.out.println("보험금 납부를 처리합니다.\n");

        System.out.println("고객 정보를 입력해주세요");
        System.out.print("성명 : ");
        String cusName = br.readLine().trim();

        // 2. 보험 정보 리스트와 버튼(납부) 출력
        System.out.println("보험 목록:");

        ArrayList<Contract> contracts = contractList.getContractListByCusName(cusName);
        for (Contract contract : contracts) {
            System.out.println("보험명: " + contract.getInsuranceName() + ", 보험료: " + contract.getPaymentAmount());
        }

        // 3. 납부를 원하는 보험 조회
        System.out.print("\n납부를 원하는 보험의 이름을 입력하세요: ");
        String insuranceName = br.readLine().trim();

        Contract contract = contractList.getContractByInsName(insuranceName);

        if (contract == null) {
            System.out.println("해당 이름의 보험을 찾을 수 없습니다.");
            return;
        } else {
            System.out.println("보험명: " + contract.getInsuranceName() + ", 보험료: " + contract.getPaymentAmount());
        }

        // 4. 납부 정보 입력창과 버튼(제출) 출력
        System.out.println("\n납부 정보를 입력하세요.");

        System.out.print("은행 이름: ");
        String bankName = br.readLine().trim();
        System.out.print("계좌번호: ");
        String accountNumber = br.readLine().trim();
        System.out.print("예금주명: ");
        String accountHolder = br.readLine().trim();

        Payment payment = new Payment(contract.getCustomerID(), contract.getInsuranceID(), contract.getPaymentAmount(), bankName, accountNumber, accountHolder);
        paymentList.add(payment);

        // 6. 납부 완료 메시지 출력
        System.out.println("\n납부가 완료되었습니다.");

    }

    public static void queryPartnerCompanies() {
        System.out.println("협력 업체 조회를 처리합니다.");
    }

    public static void assessDamage() {
        System.out.println("손해 사정을 처리합니다.");
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
        int insurancePremium = Integer.parseInt(br.readLine().trim());

        System.out.print("보상금: ");
        int compensationAmount = Integer.parseInt(br.readLine().trim());

        System.out.print("갱신 상태 (자동갱신/비갱신): ");
        String renewalStatus = br.readLine().trim();

        System.out.print("갱신 주기: ");
        int renewalCycle = Integer.parseInt(br.readLine().trim());

        System.out.print("보험 기간: ");
        int insurancePeriod = Integer.parseInt(br.readLine().trim());

        Insurance insurance = new Insurance(insuranceIndex++, insuranceName, compensationAmount, renewalStatus,
                insurancePremium, renewalCycle, insurancePeriod);

        switch (insuranceType) {
            case 1:
                insuranceList.add(insurance);
                break;
            case 2:
                registerHealthInsurance(insurance);
                break;
            case 3:
                registerCarInsurance(insurance);
                break;
            case 4:
                registerTravelInsurance(insurance);
                break;
        }

        System.out.println("\n신규 보험 등록이 완료되었습니다.");
    }

    private static void registerHealthInsurance(Insurance insurance) throws IOException {
        System.out.print("보장 질환 목록 (쉼표로 구분하여 입력하세요): ");
        String[] diseases = br.readLine().trim().split(",");
        ArrayList<String> diseaseList = new ArrayList<>(Arrays.asList(diseases));

        Insurance healthInsurance = new HealthInsurance(insurance, diseaseList);
        insuranceList.add(healthInsurance);
    }

    private static void registerCarInsurance(Insurance insurance) throws IOException {
        System.out.print("자동차 모델: ");
        String carModel = br.readLine().trim();

        System.out.print("주행 거리: ");
        int carDistance = Integer.parseInt(br.readLine().trim());

        System.out.print("자동차 생산 연도: ");
        String carYear = br.readLine().trim();

        Insurance carInsurance = new CarInsurance(insurance, carDistance, carModel, carYear);

        insuranceList.add(carInsurance);
    }

    private static void registerTravelInsurance(Insurance insurance) throws IOException {
        System.out.print("여행 국가명: ");
        String countryName = br.readLine().trim();

        System.out.print("여행 날짜: ");
        int travelDate = Integer.parseInt(br.readLine().trim());

        Insurance travelInsurance = new TravelInsurance(insurance, countryName, travelDate);
        insuranceList.add(travelInsurance);
    }

    public static void modifyInsurance() throws IOException {
        System.out.println("보험 수정을 처리합니다.\n");

        // 2. 보험 이름 입력창 출력
        System.out.print("보험 이름을 입력하세요: ");
        String insuranceName = br.readLine().trim();

        // 3. 해당 정보를 입력 후 조회
        Insurance insurance = insuranceList.getInsuranceByName(insuranceName);

        if (insurance == null) {
            System.out.println("해당 이름의 보험을 찾을 수 없습니다.");
            return;
        }

        // 4. 해당 보험의 정보 수정창 출력
        System.out.println("현재 보험 정보:");
        System.out.println("보험 이름: " + insurance.getInsuranceName());
        System.out.println("보험료: " + insurance.getPaymentAmount());
        System.out.println("보상금: " + insurance.getCompensationAmount());
        System.out.println("갱신 상태: " + insurance.getCycleType());
        System.out.println("갱신 주기: " + insurance.getPaymentCycle());
        System.out.println("보험 기간: " + insurance.getInsurancePeriod());

        System.out.println("\n새로운 정보를 입력하세요 (변경하지 않으려면 Enter 키를 누르세요):");

        // 5. 정보 수정 입력
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

        System.out.println("\n수정이 완료되었습니다.");
    }

    public static void queryCustomerInfo() throws IOException{
        System.out.println("고객 정보 조회를 처리합니다.");
        System.out.println("1. 고객 정보 등록");
        System.out.println("2. 고객 정보 조회");
        System.out.println("3. 고객 정보 수정");
        System.out.print("메뉴를 선택하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());

        switch (choice) {
            case 1:
                registerCustomerInfo();
                break;
            case 2:
                modifyCustomerInfo();
                break;
            case 3:
                viewCustomerInfo();
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }


    }

    //---------------queryCustomerInfo 내부 함수들 ----------------
    public static void registerCustomerInfo() throws IOException {
        System.out.println("고객 정보를 등록합니다.");
        System.out.print("이름: ");
        String name = br.readLine().trim();
        System.out.print("주소: ");
        String address = br.readLine().trim();
        System.out.print("나이: ");
        int age = Integer.parseInt(br.readLine().trim());
        System.out.print("생일: ");
        String birth = br.readLine().trim();
        System.out.print("이메일: ");
        String email = br.readLine().trim();
        System.out.print("성별: ");
        String gender = br.readLine().trim();
        System.out.print("전화번호: ");
        String phoneNumber = br.readLine().trim();
        System.out.print("아이디 : ");
        String customerId = br.readLine().trim();
        Customer newCustomer = new Customer(address, age, birth, customerId, email, gender, name, phoneNumber, null, null, null, null);
        customerList.add(newCustomer);
        System.out.println("고객 정보가 등록되었습니다.");
    }

    public static void modifyCustomerInfo() throws IOException {
        System.out.println("고객 정보를 수정합니다.");
        System.out.print("수정할 고객 ID: ");
        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);
        if (customer != null) {
            System.out.print("새 주소: ");
            String address = br.readLine().trim();
            System.out.print("새 이메일: ");
            String email = br.readLine().trim();
            System.out.print("새 전화번호: ");
            String phoneNumber = br.readLine().trim();
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setPhoneNumber(phoneNumber);
            System.out.println("고객 정보가 수정되었습니다.");
        } else {
            System.out.println("일치하는 고객 정보가 없습니다.");
        }
    }
    private static void viewCustomerInfo() throws IOException {
        System.out.print("조회할 고객 ID를 입력해주세요: ");

        String customerId = br.readLine().trim();
        Customer customer = customerList.getCustomerByID(customerId);
        if (customer != null) {
            System.out.println("고객 ID: " + customer.getCustomerID() + ", 이름: " + customer.getName() + ", 전화번호: " + customer.getPhoneNumber());
            System.out.println(customer.getName() + "님의 가입한 보험 리스트입니다.");
            List<Insurance> insurances = insuranceListImpl.getListByUserId(customer.getCustomerID());
            if (!insurances.isEmpty()) {
                for (Insurance insurance : insurances) {
                    System.out.println("보험 ID: " + insurance.getInsuranceID() + ", 보험 이름: " + insurance.getInsuranceName() + ", 보험금액: " + insurance.getPaymentAmount());
                }
            } else {
                System.out.println("가입한 보험이 없습니다.");
            }
        } else {
            System.out.println("일치하는 고객 정보가 없습니다.");
        }
    }
    //---------------queryCustomerInfo 내부 함수들 끝----------------

    public static void queryEmployeeInfo() {
        System.out.println("직원 정보 조회를 처리합니다.");
    }

    public static void queryContractInfo() throws IOException{
        // 이 부분도 유저별 계약 정보가 다르게 할 꺼면 로직 바꿔야 됨.
        // 지금은 보험 별로 계약 정보가 똑같다고 가정하고 만들어진 로직임.

        System.out.println("계약 정보 조회를 처리합니다.");

        System.out.println("1. 갱신 요청한다.");
        System.out.println("2. 납부 요청한다.");
        System.out.println("3. 계약을 조회한다.");
        System.out.print("선택할 번호를 입력하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());
        switch (choice) {
            case 1:
                renewContract();
                break;
            case 2:
                requestPayment();
                break;
            case 3:
                viewContract();
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }


    }

    //-------------------queryContractInfo 내부 함수들--------------------


    public static void renewContract() throws IOException {
        System.out.println("계약 갱신을 요청합니다.");
        System.out.print("갱신할 계약 번호: ");
        String contractId = br.readLine().trim();
        Contract contract = getContractById(contractId);
        if (contract != null) {
            System.out.println("계약이 갱신되었습니다.");
            // 갱신 로직 추가 -> 나중에 고민
        } else {
            System.out.println("일치하는 계약 정보가 없습니다.");
        }
    }
    public static void requestPayment() throws IOException {
        System.out.println("납부 요청을 처리합니다.");
        System.out.print("납부할 계약 번호: ");
        String contractId = br.readLine().trim();
        Contract contract = getContractById(contractId);
        if (contract != null) {
            System.out.println("납부가 요청되었습니다.");
            // 납부 요청 로직 추가 -> 나중에 고민
        } else {
            System.out.println("일치하는 계약 정보가 없습니다.");
        }
    }

    private static Contract getContractById(String contractId) {
        for (Contract contract : contracts) {
            if (contract.getInsuranceID().equals(contractId)) {
                return contract;
            }
        }
        return null;
    }
    private static void viewContract() throws IOException {
        System.out.print("조회할 계약 번호를 입력해주세요: ");
        String contractNumber = br.readLine().trim();
        Contract contract = null;
        for (Contract c : contracts) {
            if (c.getInsuranceID().equals(contractNumber)) {
                contract = c;
                break;
            }
        }
        if (contract != null) {
            System.out.println("계약 번호: " + contract.getInsuranceID());
            System.out.println("고객 이름: " + contract.getCustomerName());
            System.out.println("보험 이름: " + contract.getInsuranceName());
            System.out.println("보험료: " + contract.getPaymentAmount());
            System.out.println("보상액: " + contract.calculateCompensationAmount());
        } else {
            System.out.println("일치하는 계약 정보가 없습니다.");
        }
    }
    //-------------------queryContractInfo 내부 함수들 끝 --------------------


    public static void queryInsuranceApplication() throws IOException {
        System.out.println("보험 가입 신청 내역 조회를 처리합니다.");
        System.out.println("1. 보험 가입을 승인한다");
        System.out.print("선택할 번호를 입력하세요: ");
        int choice = Integer.parseInt(br.readLine().trim());

        if (choice == 1) {
            approveInsuranceApplication();
        } else {
            System.out.println("유효하지 않은 선택입니다. 다시 시도해 주세요.");
        }
    }
    //--------------------------queryInsuranceApplication 내부 함수들 ------------------
    public static void approveInsuranceApplication() throws IOException {
        System.out.println("보험 가입 신청을 승인합니다.");
        System.out.print("승인할 신청 ID: ");
        String applicationId = br.readLine().trim();
        //여기서 InsuranceApplication 는 2번의 결과로 유저가 보험 신청을 한 내용들임
        InsuranceApplication application = getInsuranceApplicationById(applicationId);
        if (application != null) {
            application.setApproved(true);
            System.out.println("보험 가입 신청이 승인되었습니다.");
        } else {
            System.out.println("일치하는 신청 내역이 없습니다.");

        }

    }
    private static InsuranceApplication getInsuranceApplicationById(String applicationId) {
        for (InsuranceApplication application : insuranceApplications) {
            if (application.getApplicationId().equals(applicationId)) {
                return application;
            }
        }
        return null;
    }
    //--------------------------queryInsuranceApplication 내부 함수들 끝------------------

}
