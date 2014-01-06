package graphic;

public class GraphicTest {
	
public boolean running = false;	

	public void Test(){
		Frame frame = new Frame("Test", 1920, 1050);
		
		running = true;
		
		while(running) {
			frame.update();
		}
	}

}
