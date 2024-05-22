import compensation.CompensationClaim;
import compensation.CompensationClaimListImpl;
import compensation.Servey;
import contract.Contract;
import contract.ContractListImpl;
import insurance.Insurance;
import insurance.InsuranceListImpl;
import partner.Partner;
import partner.PartnerListImpl;
import payment.Payment;
import payment.PaymentListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int insuranceIndex = 1;

    private static ContractListImpl contractList;
    private static PartnerListImpl partnerList;
    private static CompensationClaimListImpl compensationClaimList;
    private static InsuranceListImpl insuranceList;
    private static PaymentListImpl paymentList;

    public Main() {
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
    }

    public static void main(String[] args) throws IOException {
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

    public static void checkMyInsurance() {
        System.out.println("내 보험 확인을 처리합니다.");
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

        insuranceList.add(insurance);

        System.out.println("\n신규 보험 등록이 완료되었습니다.");
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

    public static void queryCustomerInfo() {
        System.out.println("고객 정보 조회를 처리합니다.");
    }

    public static void queryEmployeeInfo() {
        System.out.println("직원 정보 조회를 처리합니다.");
    }

    public static void queryContractInfo() {
        System.out.println("계약 정보 조회를 처리합니다.");
    }

    public static void queryInsuranceApplication() {
        System.out.println("보험 가입 신청 내역 조회를 처리합니다.");
    }
}
