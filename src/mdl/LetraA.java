package mdl;

/**
 *
 * @author Migue
 */
public class LetraA extends ILetra {

    public LetraA() {
        super('A');
    }

    public void run(Letra letra) {
        Lapix lapix = Lapix.getInstance();
        float dd = (float) Math.sqrt(Math.pow(lapix.getX() - letra.getX(), 2) + Math.pow(lapix.getY() - letra.getY(), 2));
        if (dd < 80) {
            Lapix.getInstance().setBonus(letra);
            letra.setTodel(true);
            Sound.play("bonus");
        }

    }

    public void setup(Letra letra) {
        letra.setDietime(50);
    }

}
