package graphic;

public class GraphicTest {
	GraphicEngine graphic = new GraphicEngine();
	Cube c1;
	Cube c2;

	public void Test(){
		graphic.CreateCube(c1, 100, 100, 200, 200, null);
		graphic.CreateCube(c2, 300, 300, 100, 100, null);
		graphic.Window(1080, 640);
		//graphic.render();
	}

}
