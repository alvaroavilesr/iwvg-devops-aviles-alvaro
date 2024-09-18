package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null);
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(1,1), Fraction::divide);
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }
}
