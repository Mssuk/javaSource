package Mall;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Board {

    static int postNumber = 100;
    ArrayList<Post> board = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    Board() {
        //기본 글
        String str = "안\n녕하\n세요?\n";
        board.add(new Post("admin", "첫번째 글입니다.", str, false, postNumber++));
    }


    public boolean addPosts(Login loginSession) {

        boolean secret = false;
        String writer = "guest";
        if (loginSession.getLoginInfo() != null) {
            writer = (String) loginSession.getLoginInfo().getKey();
        }
        System.out.println("글 제목을 입력하세요. 취소는 0번");
        String subject = scan.nextLine();
        if (subject.equals("0")) {
            return false;
        }

        System.out.println("글 제목: " + subject);
        System.out.println("글 내용을 작성하세요. 작성을 마치려면 새 줄에 :qa 입력");
        System.out.println("-------------------------------------------------------");
        String content = "";
        while (true) {
            String str = scan.nextLine();
            if (str.equals(":qa")) {
                break;
            } else
                content = content.concat(str.concat("\n"));
        }

        System.out.println("-------------------------------------------------------");
        if (writer.equals("guest")) {
            System.out.println("비밀글로 설정하려면 로그인상태여야 합니다. ");
        } else {
            System.out.println("비밀글로 설정하시겠습니까? 나와 관리자만 확인할 수 있습니다. (y:예)");
            String select2 = scan.next();
            if (select2.equals("y")) {
                secret = true;
            }
            scan.nextLine();
        }

        board.add(new Post(writer, subject, content, secret, postNumber++));
        System.out.println("글 작성 완료");
        return true;
    }


    public void removePost(int idx) {
        board.remove(idx);
        System.out.println("글 삭제 완료");
    }

    public void showBoard() {

        System.out.println("[문의게시판]");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Post post : board) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            System.out.printf("| %-15d | %-15s | %-25s | %-5s | \n", post.postNum, post.writer,
                    (post.isSecret ? "비밀글 입니다." : post.subject), format.format(post.date.getTime()));
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void showPost(int value, Login loginSession) {
        for (int i = 0; i < board.size(); ++i) {
            Post capP = board.get(i);
            if (capP.postNum == value) {
                if (capP.isSecret) {
                    if (loginSession.sessionEmpty()) {
                        System.out.println("권한이 없습니다.");
                        break;
                    } else {
                        String id = (String) loginSession.getLoginInfo().getKey();
                        if (!id.equals(capP.writer) && !id.equals("admin")) { //관리자는 모든게시글 열람가능
                            System.out.println("권한이 없습니다.");
                            break;
                        }
                    }
                }
                System.out.print("\n\n");
                System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                System.out.printf("| %-15d | %-15s | %-25s | %-5s | \n", capP.postNum, capP.writer, capP.subject, format.format(capP.date.getTime()));
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println(capP.contents);
                System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.print("\n\n");

            }
        }
    }

    public void delPost(int value) {
        for (Post p :
                board) {
            if (p.postNum == value) {
                if (board.remove(p)) {
                    System.out.println("삭제 완료");
                    break;
                } else {
                    System.out.println("오류");
                }
            }
        }
    }

}


class Post {

    int postNum;
    String writer;
    String subject;
    String contents;
    Calendar date;
    boolean isSecret;

    Post(String writer, String subject, String contents, boolean isSecret, int numbering) {
        postNum = numbering;
        this.writer = writer;
        this.subject = subject;
        this.contents = contents;
        this.isSecret = isSecret;
        date = Calendar.getInstance();
    }


}