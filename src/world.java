public class world {
    tile[] tiles;
    int sizeX, sizeY;
    world(int x,int y){
        sizeX = x;
        sizeY = y;
        tiles = new tile[sizeY*sizeY];
    }
}
