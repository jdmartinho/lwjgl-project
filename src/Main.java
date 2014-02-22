import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by jmartinho on 2/21/14.
 */
public class Main {

    private static final Logger _logger = Logger.getLogger(Main.class.getName());

    public static void main(String args[]){
        initDisplay();
        initGL();
        gameLoop();
        cleanup();
    }

    private static void initDisplay(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            _logger.log(Level.SEVERE, null, e);
        }
    }

    private static void initGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glClearColor(0,0,0,1);
        glDisable(GL_DEPTH_TEST);
    }

    private static void gameLoop(){
        while(!Display.isCloseRequested()){
            glClear(GL_COLOR_BUFFER_BIT);
            glColor3f(0.25f, 0.75f, 0.5f);
            glBegin(GL_QUADS);
            glVertex2f(0,0);
            glVertex2f(0,64);
            glVertex2f(64,64);
            glVertex2f(64,0);
            glEnd();
            Display.update();
        }
    }

    private static void cleanup(){
        Display.destroy();
    }
}
