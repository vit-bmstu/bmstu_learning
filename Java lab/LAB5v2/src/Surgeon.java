public abstract class Surgeon implements Doctor {
    protected String name;
    public Surgeon(String name) {
        this.name = name;
    }
    protected String diagnos;
    protected String patientName;

    @Override
    public void setDiagnos(String patientName, int analysis) {
        this.patientName = patientName;
        if (analysis > 5) {
            diagnos = "Ill";
        } else
            diagnos = "Well";
    }

    @Override
    public void treat() {
        if (diagnos.equals("ill")) {
            System.out.println(patientName + "stay in hospital");
        } else {
            System.out.println(patientName + "  go home");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDiagnos() {
        return diagnos;
    }

}