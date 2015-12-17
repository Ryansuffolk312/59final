////Ryan Anthony Rosario
////CST-112
////Final

///Array of objects
int many=   5;//Squid
int alot=   4;//Boat
int bunch=  10;//Triangle
int couple= 4;//Lobster
Squid    school[]=  new Squid[many];
Boat     fleet[]=   new Boat[alot];
Triangle nacho[]=   new Triangle[bunch];
Lobsters rar[]=     new Lobsters[couple];
String names[]=  { "Cali", "Mari", "Bloop", "Ward", "Tenta"};//Squid
String titles[]= {"RedL", "JackD", "RivR", "Spira"};//Boat
String tags[]=   {"Krabs", "Larry", "Claw", "Band"};//Lobster

float spacing;//between Squid
float spacingT;//between Lobster
float surface;

///Messages
String title= "CST112: Final";
String instr1= "Hold Shift and press any key to show lists. Press 'r' to reset, 'q' to exit";
String instr2= "Press 'B' to sort x, 'D' to sort dx, and 'F' to sort Storage";
String instr3= "Press 'X' to sort x, 'Y' to sort y, 'S' to sort dy, and 'L' to sort Legs";
String instr4= "Press 'C' to sort x, 'R' to sort y"; 
String author="Ryan Rosario";

float sunX=0, sunY=100, sunDX=2;

int score=0;

////Setup
void setup() {
  size( 900, 700 );
  spacing=  width/(many+1);
  spacingT=50;
  reset();
}

void reset() {
///random water height 
  surface=  width/random(2,6);
  float x=  spacing;
  float y= surface + 50;
  for (int i=0; i<many; i++ )  {school[i]=  new Squid( names[i], x ); x += spacing;}  
  for (int i=0; i<alot; i++)   {fleet[i]=   new Boat( titles[i], 100);}
  for (int i=0; i<bunch; i++)  {nacho[i]=   new Triangle(y); y+=spacingT;}
  for (int i=0; i<couple; i++) {rar[i]=      new Lobsters(tags[i]); }
  
}

///Handlers: Keys
void keyPressed() {
  ///sort Squid x,y,dy, and legs
  if (key == 'X') {sortSquidX(school, school.length);}
  if (key == 'Y') {sortSquidY(school, school.length);}
  if (key == 'S') {sortSquidDY(school, school.length);}
  if (key == 'L') {sortSquidLegs(school, school.length);}
  ///sort Boat x, dx, and Storage
  if (key == 'B') {sortBoatX(fleet, fleet.length);}
  if (key == 'D') {sortBoatDX(fleet, fleet.length);}
  if (key == 'F') {sortBoatStorage(fleet, fleet.length);}
  //sort Lobsters x,y
  if (key == 'C') {sortLobstersX(rar, rar.length);}
  if (key == 'R') {sortLobstersY(rar, rar.length);}
  //
  if (key == 'r') {reset();}
  if (key == 'q') {exit();}
}

///Next Frames
 void draw() {
  scene();
  messages(fleet, fleet.length); /// includes constructor to show the sum of all the Storage amongst ship array
///objects pause when list is shown 
 if (key >= 'A' && key <= 'Z') {
    manifest   (fleet, fleet.length);
    ecology    ( school, school.length);
    population ( rar, rar.length);
    listInfo();
  }
  else 
  action();
  show();
  
 }
 
void scene() {
  background( 0,150,200 );      
  fill( 0,50,100 );
  noStroke();
  rect( 0,surface, width, height-surface );
  fill(#E8BE13);

///Sun: position, speed, boundries
  ellipse( sunX, sunY, 50, 50);
  sunX += sunDX;
  if(sunX>width) { sunX= 0;}
}

void action() {
///Move Squids
  for (int i=0; i<many; i++ ) {school[i].move(); }
///Move Boats  
  for (int i=0; i<alot; i++) {fleet[i].move();}
///Move Lobsters
  for (int i=0; i<couple; i++) {rar[i].move();}
}

void show() {
  float x=  spacing;
///Display Squids. Make distance between them.
  for (int i=0; i<many; i++ ) {school[i].x= x; x += spacing; school[i].show();}  
///Display Boats  
  for (int i=0; i<alot; i++ ) { fleet[i].show();}
///Display Triangle
  for (int i=0; i<bunch; i++) {nacho[i].show();}
///Display Lobster
  for (int i=0; i<couple; i++) {rar[i].show();}
}

///List arrays
/////Boat arrays
 void manifest(  Boat[] n, int alot ) {
  fill(#A7B9BC);
  rect( 50, height/6, 300, 110 );
  float x=50, y=height/5.5;
  // Labels.
  fill(150,0,0);
  text( "BOAT", x+20, y );
  text( "Storage", x+65, y );
  text( "x", x+115, y );
  text( "dx", x+205, y );
  fill(0);
  // Values
 for(int i=0; i<alot; i++){
  y += 15; /// put space between each entry 
  text( n[i].name, x+20, y );
  text( n[i].storage, x+70, y );
  text( n[i].x, x+100, y );
  text( n[i].dx, x+200, y );
 }
}

////Squid arrays
 void ecology( Squid[] w, int many) {
  fill(#A7B9BC);
  rect( 50, height/2, 330, 120 );
  float x=50, y=height/1.9;
  // Labels.
  fill(150,0,0);
  text( "Names", x+20, y );
  text( "Legs", x+65, y );
  text( "x", x+115, y );
  text( "y", x+165, y );
  text( "dy", x+225, y );
  fill(0);
  //
//// Values 
 for(int i=0; i<many; i++){
  y += 15;///spacing
  text( w[i].name, x+20, y );
  text( w[i].legs, x+70, y );
  text( w[i].x, x+100, y );
  text( w[i].y, x+165, y );
  text( w[i].dy, x+225, y );
 }
}

////Lobster arrays
 void population( Lobsters[] l, int couple) {
  fill(#A7B9BC);
  rect( width/1.7, height/3, 330, 120 );
  float x=width/1.7, y=height/2.8;
  // Labels.
  fill(150,0,0);
  text( "Tags", x+20, y );
  text( "x", x+80, y );
  text( "y", x+160, y );
  fill(0);
  //
  // Values 
 for(int i=0; i<couple; i++){
  y += 15;///spacing
  text( l[i].names, x+20, y );
  text( l[i].x, x+70, y );
  text( l[i].y, x+150, y );
 
 }
}



 
 ///Sort Squid arrays: x, y, Legs, dy
void sortSquidX( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].x > a[k].x) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void sortSquidY( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].y > a[k].y) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void sortSquidLegs( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].legs > a[k].legs) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void sortSquidDY( Squid[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].dy > a[k].dy) k=  j;
    }
    swapSquid( a, m-1, k);
  }
}

void swapSquid( Squid[] a, int j, int k ) {
 
  Squid t;
  t= a[k];
  a[k]= a[j];
  a[j]= t;
  
 
}

///Sort Boat arrays, x, Storage(#legs ship has), dx
void sortBoatX( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].x > a[k].x) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void sortBoatStorage( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].storage > a[k].storage) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void sortBoatDX( Boat[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].dx > a[k].dx) k=  j;
    }
    swapBoat( a, m-1, k);
  }
}

void swapBoat( Boat[] a, int j, int k ) {
  
  Boat t;
  t= a[k];
  a[k]= a[j];
  a[j]= t;
}


///Sort Lobster arrays: x, y
void sortLobstersX( Lobsters[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].x > a[k].x) k=  j;
    }
    swapLobsters( a, m-1, k);
  }
}

void sortLobstersY( Lobsters[]a, int many ) {
  for( int m=many; m>1; m-- ) {
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j].y > a[k].y) k=  j;
    }
    swapLobsters( a, m-1, k);
  }
}

void swapLobsters( Lobsters[] a, int j, int k ) {
 
  Lobsters t;
  t= a[k];
  a[k]= a[j];
  a[j]= t;
 }


////Messages:
void messages(Boat[] a, int alot){
  textSize(20);
  fill(0);
  text(title, width/2.5, 20);
  textSize(14);
  text(instr1, width/4.5, 40);
  text(author, 20, height-20);
  //text(Score, 100, 40); 
/////Combined number of Storage(# squid legs) among Boats
  int sum = 0;
  for (int i=0; i<alot; i++) {sum += a[i].storage;}
  text( "Score " +sum, width-70, 20);
  //
  textSize(12);
}
///Sort instructions 
void listInfo(){
  textSize(14);
  text(instr2, 50, height/7.5); 
  text(instr3, 50, height/1.4);
  text(instr4, width/1.5, height/3.7);
}


    



////Classes:
class Squid {
  float x,y;
  float dx=0, dy=0; 
  float w=40, h=40;
  int legs=10; 
  String name= "";
  float r,g,b;

///Constructors
 Squid( String s, float x) {
    this.name= s;
    this.x=x;
    bottom();
    ///Squids are purplish 
    r= int(random(100, 255));
    g= int(random(0, 100));
    b= int(random(100, 250));
 }
 ///Squids start towards bottom of screen, with random speed, and random # of legs
  void bottom(){
    y= height - h;
    dy= -random( 0.1, 0.9);
    legs= int( random(1,6));
  }
///Squids move towards top of water. Get sent back to bottom    
   void move() {
     y += dy;
     if (y>height) {bottom();}
     else if (y<surface) { dy= -3 * dy; }
     for (int i=0; i<couple; i++ ) {
   ///Lobster sends Squid to bottom
   if (rar[i].hit( x, y )) {bottom();}
    }
   }

///display
 void show() {
   fill(r,g,b);
   stroke(r,g,b);
   ellipse(x,y, 40, 30);
   rect( x-40/2, y, 40, 30/2);
///legs
   stroke(r,g,b);
   strokeWeight(3);
   float legX = x-20;
   for (int i=0; i<legs; i++) {
   if(frameCount % 40 > 15) {line(legX, y+20, legX-10, y+35);}
   else                     {line(legX, y+20, legX+10, y+35);}
     legX += 10;
   }
    stroke(0);
    strokeWeight(3); 
    fill(200,200,0); 
    text( name, x-w/3, y-10+h/4 ); ////Squid names
    fill(0); 
    text( legs, x+2-w/5, y+h/3 ); ///# of legs
    fill(255); 
  } 
///hit routine 
 boolean hit( float xx, float yy ) {return dist( xx,yy, x,y ) < h;}
}
  
  
class Boat {
  float x, y=surface;
  float dx, dy;
  int storage=0, hooked=0;
  String name= "";
  float r,g,b;
///Constructor   
  Boat( String f, float x) {
    this.name= f;
    this.x= x;
    ///boats are blueish
    r= int(random(0, 10));
    g= int(random(0, 200));
    b= int(random(200, 255));
    ///Boats move at random speeds
    dx= random(1,4);
 }
 
  void move() {
   int hooked=0;
   for (int i=0; i<many; i++ ) {
   ///Boats collect legs from squid, send them back to bottom
   if (school[i].hit( x, surface )) {hooked += school[i].legs; school[i].bottom();}
    }
    storage += hooked;    
    x+=dx;
   if (x<0 || x>width) {dx *= -1;}
 }

 void show() {
    fill(r,g,b);
    ////Ship body
    rect( x, surface-20, 50, 20 ); 
    ///Head of ship
    if (dx>0)   {triangle( x+50,surface, x+50,surface-20, x+70,surface-20 );} 
    else        {triangle( x,surface, x,surface-20, x-20,surface-20 );} 
    ///wood beam
    fill(#905E37);
    rect( x+12, surface-30, 5, 10 );       
    ///sails
    fill(255); 
    if (dx>0)   {rect( x-15, surface-40, 25, 10 );}
    else        {rect( x+20, surface-40, 25, 10);}
    ///Names and Storage
    fill(255); 
    strokeWeight(3);
    text( name, x+5, surface-10 );///Name of Boat
    fill(0); 
    text( storage, x+30, surface);///# of legs
 }
}

class Triangle{
  float x1= width-45, x2= width-10;
  float y;
  float r,g,b;
  
  Triangle (float y) {
    this.y=y;
  }
  
  void show(){
   fill(255,0,0);
   triangle(x1, y, x2, y-20, x2, y+20);
  }
}

class Lobsters{
  float x,y;
  float dx, dy;
  float r,g,b;
  String names="";
  
  Lobsters(String s) {
    this.names=s;
    right();
    ///make Lobsters reddish
    r=int(random(200,255));
    g=int(random(0,100));
    b= int(random(0,10));
  }
///Lobsters start at left lower half of surface at a random y, with a random dx, and a random dy speed
  void right() {
    x=50;
    y=random(surface+50, height-20);
    dx= random(1, 2.5); dy= random(1, 2.5);
  }
  
  void move() {
///Lobsters bounce off sides of the screen, and cannot leave water    
    if (x > width|| x<0) {dx=-dx;}
    if (y > height|| y<surface) {dy=-dy;}
    
    x+=dx;
    y+=dy;
  }
  
  void show() {
    fill(r,g,b);
    stroke(r,g,b);
    strokeWeight(10);
    
    ///facing right
    if(frameCount % 30> 15 && dx>0) {
     ///Left claw
     line(x+20, y+20, x+30, y+20);
     ///Right claw
     line(x+20, y-20, x+30, y-20);}
    else if(dx>0){
     ///Left claw
     line(x+20, y+20, x+30, y+10);
     ///Right claw
     line(x+20, y-20, x+30, y-10);}
     
     ///facing left
    if(frameCount % 30> 15 && dx<0) {
     ///Left claw
     line(x-20, y+20, x-30, y+20);
     ///Right claw
     line(x-20, y-20, x-30, y-20);}
    else if(dx<0){
     ///Left claw
     line(x-20, y+20, x-30, y+10);
     ///Right claw
     line(x-20, y-20, x-30, y-10);}
     
     ///body
     ellipse(x,y,40,30);
     
     ///names
     stroke(0);
     strokeWeight(3); 
     fill(0); 
     text( names, x-40/3, y-10+40/4 ); 
  }
  ///hit rotine
  boolean hit( float xx, float yy ) {return dist( xx,yy, x,y ) < 40;}
}
    
  
  
  
  
   

   
   
  
  


     
   
