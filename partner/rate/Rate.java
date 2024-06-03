package partner.rate;

public class Rate {

    public Rate(String name, int rate, String content) {
        this.name = name;
        this.rate = rate;
        this.content = content;
    }

    private String name;
    private int rate;
    private String content;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
