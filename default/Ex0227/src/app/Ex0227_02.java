package app;

/**
 * Ex0227_02 polymorphism
 */
public class Ex0227_02 {

    public static void main(String[] args) {
        Tv t = new Tv();
        CaptionTv c = new CaptionTv();
        Tv t2 = new CaptionTv();
        // CaptionTv c2 = new Tv(); 이건 안된다.

        t2.power();
        t2.channel = 7;
        // t2.caption() 이거 안됨....

        CaptionTv c2;
        //t2 = c2; 이거는 원래 됨.

        c2 = (CaptionTv)t2; //이거 가능함.
        //CaptionTv c3=  (CaptionTv)t2; 이것도 가능함. (같은 말임)

     




        t.power();
        t.channel  = 7;
        t.channelUp();
        t.channelUp();
        t.channelDown();
        System.out.println("Tv 객체 채널: " + t.channel);

        c.power();
        c.channel  = 11;
        c.channelDown();
        c.channelDown();
        c.caption();
        c.text= "겨울왕국 2 영화 자막이 추가되었습니다.";
        c.caption();
        System.out.println("CaptionTv 객체 채널:" + c.channel);
        
        CaptionTv t3 = new CaptionTv();
        test(t3);


    }

    static void test(CaptionTv t3){
        CaptionTv tt;
        tt=t3;

        tt.channel = 3;
    }
}