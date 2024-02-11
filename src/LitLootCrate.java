import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// class for the books, but we call them bookies 'cause it's cooler
class Bookie {
    String title;
    String creator;
    int vibes;

    // constructor that sets up our bookie with a title, creator, and vibes (aka quantity)
    public Bookie(String title, String creator, int vibes) {
        this.title = title;
        this.creator = creator;
        this.vibes = vibes;
    }

    // method to snag a bookie if we've got enough vibes
    public boolean snag(int amount) {
        if (amount <= this.vibes) {
            this.vibes -= amount;
            return true;
        } else {
            return false;
        }
    }

    // method to return a bookie, increasing its vibes because it's back
    public void bounceBack(int amount) {
        this.vibes += amount;
    }
}

// main class for our lit loot crate system
public class LitLootCrate {
    private final Map<String, Bookie> stash = new HashMap<>();

    // drop a new bookie into our stash or stack more vibes if it's already there
    public void dropBookie(String title, String creator, int vibes) {
        if (stash.containsKey(title)) {
            stash.get(title).vibes += vibes;
            System.out.println("Ayy, we stacked more of " + title + " for ya!");
        } else {
            stash.put(title, new Bookie(title, creator, vibes));
            System.out.println("Yo, check it, " + title + " just dropped into the crate!");
        }
    }

    // try to snag a bookie for a bit, if we've got enough of 'em
    public void snagBookie(String title, int vibes) {
        if (stash.containsKey(title) && stash.get(title).vibes >= vibes) {
            stash.get(title).vibes -= vibes;
            System.out.println("You snagged " + vibes + " copies of " + title + ". Enjoy the ride!");
        } else {
            System.out.println("Nah, can't do. Either we're out or you're asking for too much.");
        }
    }

    // when you're done, bounce the bookie back to us
    public void bounceBookie(String title, int vibes) {
        if (stash.containsKey(title)) {
            stash.get(title).vibes += vibes;
            System.out.println("Cool, you bounced back " + vibes + " of " + title + ". Thanks for sharing the love!");
        } else {
            System.out.println("Uh oh, looks like this one's not from our crate.");
        }
    }

    // say goodbye to the crate and exit the program
    public void peaceOut() {
        System.out.println("Laters! Keep it real and come back to the crate anytime.");
        System.exit(0);
    }

    // main method to run our program and interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LitLootCrate crate = new LitLootCrate();

        while (true) {
            System.out.println("\n--- LitLootCrate Menu ---");
            System.out.println("1. Drop a Bookie");
            System.out.println("2. Snag Bookies");
            System.out.println("3. Bounce Bookies");
            System.out.println("4. Peace Out");
            System.out.print("What's it gonna be? ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume that newline

            switch (choice) {
                case 1:
                    System.out.print("Hit me with the Bookie Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Who's the brain behind it? ");
                    String creator = scanner.nextLine();
                    System.out.print("How many vibes we talking? ");
                    int vibes = scanner.nextInt();
                    scanner.nextLine();
                    crate.dropBookie(title, creator, vibes);
                    break;
                case 2:
                    System.out.print("Which Bookie you tryna snag? ");
                    title = scanner.nextLine();
                    System.out.print("How many vibes you need? ");
                    vibes = scanner.nextInt();
                    crate.snagBookie(title, vibes);
                    break;
                case 3:
                    System.out.print("Which Bookie you bouncing back? ");
                    title = scanner.nextLine();
                    System.out.print("How many vibes you returning? ");
                    vibes = scanner.nextInt();
                    scanner.nextLine();
                    crate.bounceBookie(title, vibes);
                    break;
                case 4:
                    crate.peaceOut();
                    break;
                default:
                    System.out.println("Yo, that ain't it. Try another vibe.");
                    break;
            }
        }
    }
}
