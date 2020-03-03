/**
 * Ex0303_05
 */
public class Ex0303_05 {

    public static void main(String[] args) {

        try {
            startInstall();
            copyFile();
            System.out.println(5/0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteTempFile();

        }

    }// main

    static void startInstall() {
        System.out.println("프로그램을 설치합니다. >> Install");
    }

    static void copyFile() {
        System.out.println("프로그램을 복사합니다 >>copy");
    }

    static void deleteTempFile() {
        System.out.println("임시파일을 삭제합니다.");
    }
}