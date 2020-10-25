public class Neurosurgeon extends Surgeon {

    public Neurosurgeon(String name) {
        super(name);

    }

    public void sayName(){
        System.out.println("her doctor " + name);
    }

    @Override
    public void treat() {
        if (diagnos.equals("Ill")) {
            System.out.println(patientName + " stay in hospital");
        } else {
            System.out.println(patientName + "  go home");
        }
    }
}