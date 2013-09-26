[condition][Customer]there is a (customer|passenger) with (a)? {value} loyalty level=Customer(loyaltyLevel == "{value}")

[condition][Reservation](he|she) is requesting a class upgrade=Reservation(classUpgrade=="true")
 
[consequence][]the upgrade fee is {value} (euro)?=ClassUpgradeFee fact0 = new ClassUpgradeFee(); fact0.setAmount(new BigDecimal("{value}")); insertLogical(fact0);