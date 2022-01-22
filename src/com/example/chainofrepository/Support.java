package com.example.chainofrepository;

public abstract class Support {
    // トラブル解決者の名前
    private String name;
    // 責任のたらい回し先
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    // たらい回し先の決定
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }
    // トラブル解決の手順
    public final void support (Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    // 解決用メソッド
    protected abstract boolean resolve(Trouble trouble);

    // 解決
    protected void done(Trouble trouble) {
        System.out.println(trouble + "is resolved by " + this);
    }

    // 未解決
    protected void fail(Trouble trouble) {
        System.out.println(trouble + "cannot be resolved" + this);
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }
}
