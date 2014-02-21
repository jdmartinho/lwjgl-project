import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by jmartinho on 2/21/14.
 */
public class Main {

    public static void main(String args[]){
        // Create display
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        // Game loop
        while(!Display.isCloseRequested()){
            Display.update();
        }
    }
}
