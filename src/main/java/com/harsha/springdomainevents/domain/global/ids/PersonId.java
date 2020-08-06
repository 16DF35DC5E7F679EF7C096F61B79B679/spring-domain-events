package com.harsha.springdomainevents.domain.global.ids;


public class PersonId {
    public String userId;

    private PersonId(UserIdBuilder builder) {
        this.userId = IdEncoder.encode(builder.toString());
    }

    public PersonId(String userId) {
        this.userId = userId;
    }

    public static class UserIdBuilder {
        private String name;
        private String contact;
        private String email;
        private Long dob;

        public UserIdBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserIdBuilder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public UserIdBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserIdBuilder dob(Long dob) {
            this.dob = dob;
            return this;
        }

        public PersonId build() {
            return new PersonId(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "name='" + name + '\'' +
                    ", contact='" + contact + '\'' +
                    ", email='" + email + '\'' +
                    ", dob=" + dob +
                    '}';
        }
    }
}
