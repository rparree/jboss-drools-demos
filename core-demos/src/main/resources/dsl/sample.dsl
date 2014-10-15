[condition][Member]there is a (member|passenger) with (a)? {value} loyalty level=Member(loyaltyLevel == "{value}")

[condition][Reservation](he|she) is requesting a class upgrade=Reservation(classUpgrade=="true")
 
[consequence][]the upgrade fee is {value} (miles)?=Miles miles = new Miles(new Double("{value}")); insertLogical(miles);