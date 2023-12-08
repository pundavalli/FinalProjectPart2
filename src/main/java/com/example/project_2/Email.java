package com.example.project_2;

public class Email {
    private String user_name, domain_name;

    public Email(String user_name, String domain_name) {
        this.user_name = user_name;
        this.domain_name = domain_name;
        if (!(domain_name.contains(".com") && domain_name.contains(".net") && domain_name.contains(".fr") && domain_name.contains(".co.uk") && domain_name.contains(".gov"))) {
            throw new IllegalArgumentException("Not a proper domain name");
        }
    }

    public Email(String email) {
        String[] parts = email.split("@");
        user_name = parts[0];
        domain_name = parts[1];
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    @Override
    public String toString() {
        return user_name + "@" + domain_name;
    }
}
