package graphic;

public class GraphicTest {
	
public boolean running = false;	

	public void Test(){
		Frame frame = new Frame("Test", 600, 500);
		
		running = true;
		
		while(running) {
			frame.update();
		}
	}

}
