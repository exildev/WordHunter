package mdl;

/**
 *
 * @author Migue
 */
public class LetraB extends ILetra {

    public LetraB() {
        super('B');
    }

    public void run(Letra letra) {
        Lapix lapix = Lapix.getInstance();
        float dd = (float) Math.sqrt(Math.pow(lapix.getX() - letra.getX(), 2) + Math.pow(lapix.getY() - letra.getY(), 2));
        if (dd < 80) {
            lapix.setBlock(3);
            Sound.play("block");
        }
    }

    public void setup(Letra letra) {
        letra.setDietime(30);
    }

}
