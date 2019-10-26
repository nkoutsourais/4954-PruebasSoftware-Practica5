## 4954-PruebasSoftware-Practica5
### Practica 5
* Fecha de entrega: 28/10/2019
* Integrantes:
  * Neo Koutsourais


## Diagrama MasterMind

<p align="center">
  <img alt="" src="">
</p>

### PlantUML
 
 ```PlantUML
@startuml


class LasDamas {
+ play()
}
LasDamas *-down-> Logic
LasDamas *-down-> View

interface View {
+ interact(Controller)
}

class StartView #orange {
+ interact(StartController)
}

class PlayView  #orange {
+ interact(PlayController)
}

class ResumeView  #orange {
+ interact(ResumeController)
}

StartView ..> StartController
PlayView ..> PlayController
ResumeView ..> ResumeController

View ()-- StartView
View ()-- PlayView
View ()-- ResumeView
StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView ..> SquareView
SquareView ..> PieceView

View ..> Controller
AcceptController <|-down- View

class Logic{
+ getController()
}

Logic *--> State
Logic *--> Game
Logic *-down-> AcceptController

abstract class Controller{
}

interface AcceptController{
}

Controller ..> AcceptController
Controller <|-down- StartController
Controller <|-down- PlayController
Controller <|-down- ResumeController
Controller o--> Game

class StartController{
 + start():void
}

class MoveController{
}

class CancelController{
}

class ResumeController{
 + resume(boolean newGame):void
}

class PlayController{
+ move(Coordinate origin, Coordinate target):Error
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
}
Game *-down-> Board
Game *-down-> Turno
Game ..> Error

class Board{
}
Board *-down-> "8x8" Square
Board *-down-> "1..2x12" Piece
Board ..> Error

class Square{
}
Square  --> "0..1" Piece

class Piece{
}
Piece <|-down- Peon
Piece <|-down- Dama
Piece *--> Color 

class Peon{
}

class Dama{
}

enum Color{
    WHITE
    BLACK
}

class Turn{
}
Turn *--> Color

class State{
}
State *--> StateValue

enum StateValue{
  INITIAL
  PLAY
  FINAL
  EXIT
}

enum Error{
}

@enduml

 ```