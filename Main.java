import contract.Contract;
import customer.Customer;
import customer.CustomerListImpl;
import insurance.Insurance;
import insurance.InsuranceApplication.InsuranceApplication;
import insurance.InsuranceListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static CustomerListImpl customerList = new CustomerListImpl();
    private static InsuranceListImpl insuranceListImpl = new InsuranceListImpl();
    private static List<Contract> contracts = new ArrayList<>();

    private static List<InsuranceApplication> insuranceApplications = new ArrayList<>(); // 보험 가입 신청 내역을 저장하는 리스트

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
        System.out.println("1. 보험금 청구");
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

    public static void claimInsurance() {
        System.out.println("보험금 청구를 처리합니다.");
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

    public static void payInsurance() {
        System.out.println("보험금 납부를 처리합니다.");
    }

    public static void queryPartnerCompanies() {
        System.out.println("협력 업체 조회를 처리합니다.");
    }

    public static void assessDamage() {
        System.out.println("손해 사정을 처리합니다.");
    }

    public static void registerInsurance() {
        System.out.println("보험 등록을 처리합니다.");
    }

    public static void modifyInsurance() {
        System.out.println("보험 수정을 처리합니다.");
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
