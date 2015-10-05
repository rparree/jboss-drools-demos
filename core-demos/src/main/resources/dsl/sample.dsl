[keyword]donc=then

[when]there is a (member|passenger) with (a)? {value} loyalty level=Member(loyaltyLevel == "{value}")

[when](he|she) is requesting a class upgrade=Reservation(classUpgrade=="true")
 
[then]the upgrade fee is {value} (miles)?=Miles miles = new Miles(new Double("{value}")); insertLogical(miles);

