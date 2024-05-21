import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    public static void checkMyInsurance() {
        System.out.println("내 보험 확인을 처리합니다.");
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
