import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// Game mechanics and code by Cameron Drummond

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner kb = new Scanner(System.in);
        System.out.println("Hello, my name is Lexter. I'm not a Pokedex like my brother. I just do math. Press anything to start me.");
        String cmd = kb.nextLine();
        if (cmd.equals("end")) {
            System.exit(0);
        } else {
            while (!cmd.equals("quit")
            ) {

                System.out.println(" " +
                        "_______________________________________________________\n" +
                        "|                                                      |\n"+
                        "|               (   )               (   )              |\n" +
                        "|              (  o  )             (  o  )             |           --------------------------\n" +
                        "|               (   )               (   )              |          |What would you like to do?|\n" +
                        "|                                                      |       /~~ --------------------------\n" +
                        "|                       _______                        |      /\n" +
                        "|                       \\---                           |   ,/\n"+
                        "|______________________________________________________|\n"+
                        "|0                                                     |\n" +
                        "|0                                                     |\n" +
                        "|             Capture Calculator? (Capture/c)          |\n"+
                        "|             Attack Calculator? (Attack/a)            |\n"+
                        "|             Normal Calculator? (Normal/n)            |\n"+
                        "|             Poaching Price? (Poach/p)                |\n"+
                        "|             Quit? (quit)                             |\n"+
                        "|             ...                                      |\n" +
                        "|0                                                     |\n" +
                        "|0                                                     |\n" +
                        "|______________________________________________________|\n");
                cmd = kb.nextLine();
                if (cmd.equals("Capture") || cmd.equals("capture") || cmd.equals("cap") || cmd.equals("c")) {
                    System.out.println("What type of Pokemon are you capturing? (Baby(1), Basic(2), Stage1(3), Stage2(4), Legendary(5))");
                    double BC = 100; //starting number and total to use
                    Random random = new Random();
                    double i1 = (Math.random() * ((225 - 200) + 1)) + 200;
                    double i2 = (Math.random() * ((199 - 150) + 1)) + 150;
                    double i3 = (Math.random() * ((149 - 100) + 1)) + 100;
                    double i4 = (Math.random() * ((99 - 50) + 1)) + 50;
                    double i5 = (Math.random() * ((49 - 10) + 1)) + 10;
                    int type1 = kb.nextInt(); //this type is a check
                    double type2 = 1; //this type is for the actual value
                    if (type1 == 1) type2 = i1;
                    if (type1 == 2) type2 = i2;
                    if (type1 == 3) type2 = i3;
                    if (type1 == 4) type2 = i4;
                    if (type1 == 5) type2 = i5;
                    type2 = Math.round(type2);//type2 is capture rate
                    //System.out.println(type2);

                    System.out.println("What is the Pokemon's max HP?");
                    double max = kb.nextDouble();
                    System.out.println("What is the Pokemon's current HP?");
                    double current = kb.nextDouble();
                    System.out.println("What is the ball multiplier?(Pokeball 1, Greatball 1.2, Ultraball 1.5, Effectball if apply 2");
                    double bonusball = kb.nextDouble();
                    System.out.println("Is the Pokemon [Asleep Frozen] (1), [Paralyzed Burned Poisoned] (2), [Flinched Infatuated Confused] (3), or nothing is wrong (4)?");
                    int ali_check = kb.nextInt();
                    double bonusstat = 1.0;
                    if (ali_check == 1) bonusstat = 1.5;
                    if (ali_check == 2) bonusstat = 1.2;
                    if (ali_check == 3) bonusstat = 1.1;
                    if (ali_check == 4) bonusstat = 1.0;

                    BC = Math.round((((3 * max - 2 * current) * type2 * bonusball) / (3 * max)) * bonusstat);
                    if (BC > 100) BC = 99;

                    System.out.println("The Capture roll (1D100) must be less than or equal to " + BC + "\n");
                    cmd = kb.nextLine();
                } else if (cmd.equals("Attack") || cmd.equals("attack") || cmd.equals("a")) {
                    System.out.println("What is the level of the attacking Pokemon?");
                    double lvl = kb.nextDouble();
                    System.out.println("What is the power of the move?");
                    double pwr = kb.nextDouble();
                    //System.out.println(pwr);
                    System.out.println("What is the attacking Pokemon's Attack or Special Attack at after stat boosts?");
                    int attackstat = kb.nextInt();
                    //System.out.println(attackstat);
                    System.out.println("What is the Defending Pokemon's Defense or Special Defense at after stat boosts?");
                    double defstat = kb.nextDouble();
                    //System.out.println(defstat);
                    System.out.println("Is the Defending Pokemon Resistant or Super effective to the attack's type? (.5, .75, 1, 1.5, 2)");
                    double weak = kb.nextDouble();
                    //System.out.println(weak);
                    System.out.println("Does the Attacker's Ability or Item add anything? (1 if none add together if needed)");
                    double ability = kb.nextDouble();
                    //System.out.println(ability);
                    System.out.println("Any Critical Buff/Ability/Move? (0, 1, 2, 3, 4)");
                    double crit = kb.nextDouble();
                    Random rand = new Random();
                    double critdamage = 1;
                    double critcheck;
                    if (crit == 0) {
                        critcheck = 4;
                        int check1 = rand.nextInt(99);
                        check1 += 1;
                        if (critcheck >= check1) {
                            critdamage = 1.5;
                        }
                    }
                    if (crit == 1) {
                        critcheck = 13;
                        int check1 = rand.nextInt(99);
                        check1 += 1;
                        if (critcheck >= check1) {
                            critdamage = 1.5;
                        }
                    }
                    if (crit == 2) {
                        critcheck = 50;
                        int check1 = rand.nextInt(99);
                        check1 += 1;
                        if (critcheck >= check1) {
                            critdamage = 1.5;
                        }
                    }
                    if (crit == 3) {
                        critcheck = 100;
                        int check1 = rand.nextInt(99);
                        check1 += 1;
                        if (critcheck >= check1) {
                            critdamage = 1.5;
                        }
                    }
                    if (crit == 4) {
                        critcheck = 100;
                        int check1 = rand.nextInt(99);
                        check1 += 1;
                        if (critcheck >= check1) {
                            critdamage = 1.5;
                        }
                    }
                    System.out.println("Any Weather impacting the attack? (.5 1.5)");
                    double weather = kb.nextDouble();
                    // System.out.println(weather);
                    System.out.println("Do you have STAB with your move? (y/n)");
                    double stab;
                    String cmd3 = kb.nextLine();
                    cmd3 = kb.nextLine();
                    if (cmd3.equals("y") || cmd3.equals("Y")) {
                        stab = 1.5;
                    } else {
                        stab = 1;
                    }
                    double burn;
                    System.out.println("Is the attacking Pokemon using their Attack stat and is burned? (y/n?)");
                    String cmd2 = kb.nextLine();
                    //cmd2 = kb.nextLine();
                    //System.out.println(cmd2);
                    if (cmd2.equals("y") || cmd2.equals("Y")) {
                        burn = .5;
                    } else {
                        burn = 1;
                    }
                    double modifier;
                    Random r = new Random();
                    double x = .85 + (1 - .85) * r.nextDouble();
                    modifier = weather * critdamage * x * stab * weak * burn * ability;
                    double num1 = ((2 * lvl) / 5) + 2;
                    double num2 = pwr * (attackstat / defstat);
                    double num3 = num1 * num2;
                    double damage = ((num3 / 50) + 2) * modifier;
                    if (damage < 0) damage = 1;
                    if (critdamage > 1) {
                        System.out.println("It was a Critical Hit!");
                    }
                    System.out.println("Damage is: " + Math.round(damage) + "\n");
                    cmd = kb.nextLine();

                } else if (cmd.equals("Normal") || cmd.equals("normal") || cmd.equals("n")) {
                    double num1, num2;

                    System.out.print("Enter first value: ");

                    num1 = kb.nextDouble();
                    System.out.print("Enter second value: ");
                    num2 = kb.nextDouble();

                    System.out.print("Enter an operator (+, -, *, /): ");
                    char operator = kb.next().charAt(0);

                    double output;

                    switch (operator) {
                        case '+':
                            output = num1 + num2;
                            break;

                        case '-':
                            output = num1 - num2;
                            break;

                        case '*':
                            output = num1 * num2;
                            break;

                        case '/':
                            output = num1 / num2;
                            break;

                        default:
                            System.out.print("You have entered a wrong operator user");
                            return;
                    }

                    System.out.println(num1 + " " + operator + " " + num2 + " = " + output + "\n");
                    cmd = kb.nextLine();
                } else if (cmd.equals("Poach") || cmd.equals("poach") || cmd.equals("poa") || cmd.equals("p")) {
                    System.out.println("How rare is the Pokemon itself? [1-5]");
                    double rare = kb.nextDouble();
                    //System.out.println(rare);
                    System.out.println("How rare is that Pokemon in the area it's being sold? [1-5]");
                    double area = kb.nextDouble();
                    //System.out.println(area);
                    System.out.println("What level is the Pokemon?");
                    double lvl = kb.nextDouble();
                    //System.out.println(lvl);
                    double yen_value = 1000;
                    if (rare == 1 && area == 1) {
                        yen_value = 100;
                    }
                    if (rare == 4 && area == 4) {
                        yen_value = 1500;
                    }
                    if (rare == 5 && area == 5) {
                        yen_value = 10000;
                    }
                    double price = (((rare * area) * (lvl / 2)) * yen_value);
                    System.out.println("This Pokemon's starting price is: " + price + " Yen.\n");
                    cmd = kb.nextLine();
                } else if (cmd.equals("quit")) {
                    System.out.println("Powering down...");
                    Thread.sleep(3000);
                    System.exit(0);
                } else {

                    System.out.println("That was an incorrect input, try again beep boop.");

                }
            }
        }
    }
}

