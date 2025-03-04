package optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // of, empty, ofNullable
        String email = "yuvan@test.com";
        
        // using empty
        // it provides an optional with null value
        System.out.println("empty() demo start:");
        Optional<Object> usingEmptyOptional = Optional.empty();
        System.out.println("empty() demo result:" +usingEmptyOptional);

        // using of ( it internally checks for null and throws the NPE
        System.out.println("of() demo start:");
        Optional<String> email1Optional = Optional.of(email);
        System.out.println("of() demo result:" +email1Optional);

        // using ofNullable
        // if value is null then it provides the empty optional instead of throwing NPE
        System.out.println("ofNullable() demo with null:");
        Optional<String> stringOptional2 = Optional.ofNullable(email);
        System.out.println(stringOptional2);
        // if we directly use the get() then it throws the NoSuchElementException if the value is null.
        // Hence to avoid that, we need to access only if it is present using isPresent()
        if(stringOptional2.isPresent()) {
            System.out.println("inside stringOptional2.isPresent()");
            System.out.println(stringOptional2.get());
        }

        System.out.println("ofNullable() demo with null:");
        Optional<String> stringOptional = Optional.ofNullable(null);

        System.out.println("orElse demo");
        System.out.println(stringOptional.orElse("default@orelse.com"));

        System.out.println("orElseGet demo");
        System.out.println(stringOptional.orElseGet(() -> "default@orelseget.com"));

        System.out.println("ifPresent demo");
        stringOptional.ifPresent((s)->{
            System.out.println("value is present");
        });

        System.out.println("isPresent demo");
        if(stringOptional.isPresent()) {
            System.out.println("inside stringOptional.isPresent()");
            System.out.println(stringOptional.get());
        }

        System.out.println("filter demo with out using optional class:");
        if(email != null && email.contains(".com")){
            System.out.println(email);
        }

        System.out.println("filter demo using optional class:");
        Optional<String> strEmailOptional = Optional.ofNullable(email);
        strEmailOptional.filter(res -> res.contains(".com"))
                .ifPresent(res -> System.out.println(res));

        // map method in Optional provides a way to transform value in Optional from one type to another
        System.out.println("map demo");
        strEmailOptional.filter(val -> val.contains(".com"))
                .map(String::toUpperCase)
                        .ifPresent(val -> System.out.println(val));

        System.out.println("orElseThrow demo");
        System.out.println(stringOptional.orElseThrow(() -> new IllegalArgumentException("Email is not exist")));
    }
}
