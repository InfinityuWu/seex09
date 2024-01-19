package decorator

trait Pizza:
    def diameter: Int
    def price: BigDecimal

class Margherita extends Pizza:
    override def diameter: Int = 28
    override def price: BigDecimal = 9

class Funghi extends Margherita:
    override def price: BigDecimal = 10

class Verdura extends Margherita:
    override def price: BigDecimal = 11.5

@main def Pizzashop(): Unit =
    // pizza Verdura with extra cheese
    val p1: Pizza = new Cheese(new Verdura);
    // pizza Funghi family size with vegan cheese
    val p2: Pizza = new FamilySize(new VeganCheese(new Funghi));

    println(s"Price of a pizza verdura with extra cheese is ${p1.price}")

    println(s"Price of a pizza funghi family size with vegan cheese is ${p2.price}")
    

// === ADD YOUR CODE BELOW ===
class Cheese(pizza: Pizza) extends Pizza:
    override def price: BigDecimal = pizza.price + 2;
    override def diameter: Int = pizza.diameter;

class VeganCheese(pizza: Pizza) extends Pizza:
    override def price: BigDecimal = pizza.price + 1.5;

    override def diameter: Int = pizza.diameter;

class Onion(pizza: Pizza) extends Pizza:
    override def price: BigDecimal = pizza.price + 1;

    override def diameter: Int = pizza.diameter;

class FamilySize(pizza: Pizza) extends Pizza:
    override def price: BigDecimal = pizza.price * 2;

    override def diameter: Int = 42;

// === ADD YOUR CODE ABOVE ===
