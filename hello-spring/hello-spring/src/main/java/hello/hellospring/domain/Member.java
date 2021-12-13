package hello.hellospring.domain;

public class Member {

    // 요구사항 아이디와 이름름
   private Long id;
   private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
