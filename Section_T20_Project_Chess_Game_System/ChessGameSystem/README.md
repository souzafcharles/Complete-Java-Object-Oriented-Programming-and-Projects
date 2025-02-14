# Introduction:

This system is designed to simulate a full-fledged chess game using object-oriented programming principles. The
application comprises several classes and components, each responsible for different aspects of the game, from the board
setup to the intricate details of piece movements and special chess rules.

The core of the system revolves around the `Board` and `Piece` classes, which serve as the foundation for representing
the chessboard and its pieces. Through encapsulation, inheritance, and polymorphism, these classes interact seamlessly
to manage the game's state and logic.

Key highlights of the system include:

- [x] **Position Class**: This class represents a position on the chessboard, encapsulating the coordinates in a
  straightforward manner.

- [x] **Board and Piece Classes**: These classes define the structure of the chessboard and the pieces placed on it,
  leveraging encapsulation and access modifiers to maintain the integrity of the game state.

- [x] **Chess Layer**: This layer manages the printing of the board and the visual representation of the game's state,
  ensuring that players can see the current setup and plan their moves accordingly.

- [x] **Piece Placement**: The system includes methods for placing pieces on the board, ensuring that the initial setup
  adheres to standard chess rules.

- [x] **Exception Handling**: Custom exception classes like `BoardException` and `ChessException` are implemented to handle
  errors and invalid moves gracefully, enhancing the robustness of the application.

- [x] **Chess-Specific Classes**: The system encompasses a variety of chess pieces, including the `Rook`, `King`, `Bishop`,
  `Knight`, `Queen`, and `Pawn`, each with its unique movement logic and characteristics.

- [x] **Special Moves**: The application supports special moves such as castling, en passant, and pawn promotion, adhering
  to the official rules of chess.

- [x] **Game Mechanics**: Classes like `ChessMatch` manage the overall game flow, including turn management, move
  validation, check, and checkmate logic, ensuring a comprehensive chess-playing experience.

- [x] **User Interface**: The `UI` class handles the interaction with the players, printing the board, reading moves, and
  displaying game status, leveraging ANSI color codes for an enhanced visual experience.

Overall, this system provides a comprehensive simulating a chess game, adhering to object-oriented principles and
ensuring a seamless and enjoyable experience for the players. The implementation details and requirements for each
component are meticulously outlined to facilitate understanding and further development.

### 1. Printing the Board:

![Chess Game System ](https://github.com/souzafcharles/Complete-Java-Object-Oriented-Programming-and-Projects/blob/main/Section_T20_Project_Chess_Game_System/ChessGameSystem/src/com/souza/charles/resources/static/img/ChessGameSystem.png)

***

## Board Game Layer:

### 1. The Position Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Position` entity class.
The `Position` class represents the coordinates of a position on a board and includes essential features such as
encapsulation, constructors, and a `toString` method.

#### 2.1. Requirements for Position Entity Class:

- **Class Definition:**
    - Define the `Position` class as a public class to represent a position on the board.
    - Ensure that the class is located in the `com.souza.charles.boardgame` package.

- **Attributes and Encapsulation:**
    - Define private attributes `row` and `column` to store the position's row and column values.
    - Use the principle of encapsulation to control access to the attributes.

- **Constructors:**
    - Provide a constructor with parameters for `row` and `column` to initialize the attributes.
    - Ensure the constructor assigns the provided values to the respective attributes.

- **Accessors and Mutators:**
    - Implement `getter` methods (`getRow()` and `getColumn()`) to retrieve the attribute values.
    - Implement `setter` methods (`setRow()` and `setColumn()`) to modify the attribute values.

- **Set Values Method:**
    - Provide a method `setValues(int row, int column)` to update both `row` and `column` attributes simultaneously.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the position.
    - Ensure that the `toString()` method returns a string in the format "row, column".

***

### 2. The Board Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Board` class. This class
is a fundamental component within the board game system, encompassing essential principles of object-oriented
programming such as encapsulation, constructors, and method overriding.

#### 2.1. Requirements for Board Entity Class:

- **Class Definition:**
    - Define the `Board` class as a public class to represent the game board.
    - Ensure that the class is located in the `com.souza.charles.boardgame` package.

- **Attributes and Encapsulation:**
    - Define private attributes `rows`, `columns`, and `pieces` to store the dimensions and pieces of the board.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `rows` and `columns` to initialize the board dimensions.
    - Ensure the constructor initializes the `pieces` array based on the board dimensions.
    - Include validation to ensure the board has at least one row and one column, throwing a `BoardException` if this
      condition is not met.

- **Accessors and Mutators:**
    - Implement `getter` methods (`getRows()` and `getColumns()`) to retrieve the board dimensions.
    - Provide methods to manage pieces on the board, including `piece(int row, int column)`, `piece(Position position)`,
      `placePiece(Piece piece, Position position)`, and `removePiece(Position position)`.

- **Position Validation Methods:**
    - Implement private method `positionExists(int row, int column)` to check if a position is within the board
      boundaries.
    - Implement public method `positionExists(Position position)` to check if a `Position` object is within the board
      boundaries.
    - Provide a method `thereIsAPiece(Position position)` to check if a position contains a piece.

### 3. The Piece Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Piece` class. This class
is a fundamental component within the board game system, encompassing essential principles of object-oriented
programming such as encapsulation, constructors, and method overriding.

#### 3.1. Requirements for Piece Entity Class:

- **Class Definition:**
    - Define the `Piece` class as an abstract public class to represent game pieces.
    - Ensure that the class is located in the `com.souza.charles.boardgame` package.

- **Attributes and Encapsulation:**
    - Define protected attribute `position` to store the position of the piece.
    - Define private attribute `board` to associate the piece with the board it belongs to.
    - Use the principle of encapsulation to control access to these attributes, allowing subclasses to access
      `position`.

- **Constructors:**
    - Provide a constructor with a parameter for `Board` to initialize the `board` attribute.
    - Ensure the constructor initializes the `position` attribute to `null`.

- **Abstract Methods:**
    - Declare an abstract method `boolean[][] possibleMoves()` to be implemented by subclasses, defining the possible
      moves for the piece.

- **Accessors and Utility Methods:**
    - Implement a protected method `getBoard()` to retrieve the associated board.
    - Provide methods `possibleMove(Position position)` to check if a move is possible and `isThereAnyPossibleMove()` to
      verify if there are any possible moves for the piece.

***

## Chess Game Layer:

### 1. The Color, ChessPiece, and ChessPosition Classes - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Color` enum class. This
class is a fundamental component within the board game system, encompassing essential principles of object-oriented
programming such as encapsulation, constructors, and method overriding.

#### 1.1. Requirements for Color Enum Class:

- **Enum Definition:**
    - Define the `Color` enum to represent the colours of the chess pieces.
    - Ensure that the enum is located in the `com.souza.charles.chessgame` package.

- **Enum Values:**
    - Define two enum values: `BLUE` and `RED`, to represent the two teams in the game.

### 2. The ChessPiece Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `ChessPiece` enum class.
This class is a fundamental component within the board game system, encompassing essential principles of object-oriented
programming such as encapsulation, constructors, and method overriding.

#### 2.1 Requirements for ChessPiece Entity Class:

- **Class Definition:**
    - Define the `ChessPiece` class as an abstract class to represent generic chess pieces.
    - Ensure that the class is located in the `com.souza.charles.chessgame` package.

- **Attributes and Encapsulation:**
    - Define private attributes `color` and `moveCount` to store the piece's colour and the number of moves it has made.
    - Use the principle of encapsulation to control access to these attributes.
    - Inherit the protected attribute `position` from the `Piece` class.

- **Constructors:**
    - Provide a constructor with parameters for `Board` and `Color` to initialize the `board` and `color` attributes.
    - Ensure the constructor initializes the `position` attribute to `null`.

- **Accessors and Mutators:**
    - Implement `getter` methods (`getColor()` and `getMoveCount()`) to retrieve the attribute values.
    - Implement methods `increaseMoveCount()` and `decreaseMoveCount()` to update the `moveCount` attribute.

- **Utility Methods:**
    - Implement the method `getChessPosition()` to retrieve the position of the piece in chess notation.
    - Implement the method `isThereOpponentPiece(Position position)` to check if a position contains an opponent's
      piece.

### 3. The ChessPosition Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `ChessPosition` enum class.
This class is a fundamental component within the board game system, encompassing essential principles of object-oriented
programming such as encapsulation, constructors, and method overriding.

#### 3.1. Requirements for ChessPosition Entity Class:

- **Class Definition:**
    - Define the `ChessPosition` class to represent the position of pieces on the chessboard using chess notation.
    - Ensure that the class is located in the `com.souza.charles.chessgame` package.

- **Attributes and Encapsulation:**
    - Define private attributes `column` and `row` to store the column (as a character) and row (as an integer) values.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `column` and `row` to initialize the attributes.
    - Ensure the constructor performs validation to check if the column and row values are within the valid range (`a`
      to `h` for columns and `1` to `8` for rows), throwing a `ChessException` if the values are out of range.

- **Conversion Methods:**
    - Implement the method `toPosition()` to convert a `ChessPosition` to a `Position` object.
    - Implement a static method `fromPosition(Position position)` to convert a `Position` object to a `ChessPosition`.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the chess position.
    - Ensure that the `toString()` method returns a string in the format "columnrow".

***

### 4. ChessMatch Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `ChessMatch` class. The
`ChessMatch` class encapsulates the state and behaviour of a chess game, managing the board, pieces, and game logic.

#### 4.1. Requirements for ChessMatch Class:

- **Class Definition:**
    - Define the `ChessMatch` class as a public class to represent a chess match.
    - Ensure that the class is located in the `com.souza.charles.chessgame` package.

- **Attributes and Encapsulation:**
    - Define private attributes `turn`, `currentPlayer`, `board`, `check`, `checkMate`, `enPassantVulnerable`, and
      `promoted` to manage the game state.
    - Define private lists `piecesOnTheBoard` and `capturedPieces` to track the pieces on the board and the captured
      pieces.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a no-argument constructor to initialise the chess match.
    - Initialize the `board` attribute with an 8x8 board, set `turn` to 1, `currentPlayer` to `Color.RED`, and call
      `initialSetup()` to set up the initial board state.

- **Accessors:**
    - Implement `getter` methods (`getTurn()`, `getCurrentPlayer()`, `getCheck()`, `getCheckMate()`,
      `getEnPassantVulnerable()`, and `getPromoted()`) to retrieve the attribute values.

- **Game Logic Methods:**
    - Implement method `getPieces()` to return the current state of the board as a 2D array of `ChessPiece` objects.
    - Implement method `possibleMoves(ChessPosition sourcePosition)` to return possible moves for a piece at a given
      source position.
    - Implement method `performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition)` to execute a move
      from the source position to the target position, handling special moves like promotion and en passant, and
      updating the game state accordingly.

- **Promotion Logic:**
    - Implement method `replacePromotedPiece(String type)` to replace a promoted pawn with a new piece of the specified
      type.
    - Implement private method `newPiece(String type, Color color)` to create a new piece based on the type and color.

- **Move and Undo Move Logic:**
    - Implement private methods `makeMove(Position source, Position target)` and
      `undoMove(Position source, Position target, Piece capturedPiece)` to execute and undo moves, handling special
      moves like castling and en passant.

- **Validation Methods:**
    - Implement private method `validateSourcePosition(Position position)` to ensure that the source position contains a
      piece that belongs to the current player and that the piece has possible moves.
    - Implement private method `validateTargetPosition(Position source, Position target)` to ensure that the target
      position is a valid move for the piece at the source position.

- **Turn Management:**
    - Implement private method `nextTurn()` to increment the turn counter and switch the current player.

- **Opponent and King Retrieval:**
    - Implement private method `opponent(Color color)` to return the colour of the opponent player.
    - Implement private method `king(Color color)` to retrieve the `King` piece of the specified colour from the board.
      Throw an `IllegalStateException` if there is no king of the specified colour.

- **Check and Checkmate Testing:**
    - Implement private method `testCheck(Color color)` to determine if the king of the specified colour is in check.
    - Implement private method `testCheckMate(Color color)` to determine if the specified colour is in checkmate.

- **Piece Placement and Initial Setup:**
    - Implement private method `placeNewPiece(char column, int row, ChessPiece piece)` to place a new piece on the board
      at the specified position.
    - Implement private method `initialSetup()` to set up the initial positions of all chess pieces on the board at the
      start of the game.

***

### 5. Bishop Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Bishop` class. The
`Bishop` class represents the bishop piece in the chess game, encapsulating its specific movement logic and
characteristics.

#### 5.1. Requirements for Bishop Class:

- **Class Definition:**
    - Define the `Bishop` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board` and `Color` to initialize the bishop piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the bishop.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the bishop, allowing it to move diagonally in all four directions (northwest,
      northeast, southeast, southwest).
    - Ensure that the bishop can move as long as the target positions are within the board boundaries and not occupied
      by another piece of the same color.
    - Allow the bishop to capture opponent pieces by moving to their positions.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the bishop.
    - Ensure that the `toString()` method returns the emoji "♗" to represent the bishop.

***

### 6. King Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `King` class. The `King`
class represents the king piece in the chess game, encapsulating its specific movement logic and characteristics.

#### 6.1. Requirements for King Class:

- **Class Definition:**
    - Define the `King` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Define a private attribute `chessMatch` to manage the context of the chess match.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board`, `Color`, and `ChessMatch` to initialize the king piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the king.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the king, allowing it to move one square in any direction (vertically,
      horizontally, and diagonally).
    - Ensure that the king can move as long as the target positions are within the board boundaries and not occupied by
      another piece of the same color.

- **Special Moves:**
    - Implement the method `testRookCastling(Position position)` to check if castling is possible with a rook.
    - Implement the logic for castling within the `possibleMoves()` method, allowing the king to perform the special
      move if the conditions are met (rook and king have not moved, and the squares between them are unoccupied).

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the king.
    - Ensure that the `toString()` method returns the emoji "♔" to represent the king.

***

### 7. Knight Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Knight` class. The
`Knight` class represents the knight piece in the chess game, encapsulating its specific movement logic and
characteristics.

#### 7.1. Requirements for Knight Class:

- **Class Definition:**
    - Define the `Knight` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board` and `Color` to initialize the knight piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the knight.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the knight, allowing it to move in an "L" shape (two squares in one direction and
      then one square perpendicular).
    - Ensure that the knight can move as long as the target positions are within the board boundaries and not occupied
      by another piece of the same color.
    - Allow the knight to capture opponent pieces by moving to their positions.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the knight.
    - Ensure that the `toString()` method returns the emoji "♘" to represent the knight.

***

### 8. Pawn Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Pawn` class. The `Pawn`
class represents the pawn piece in the chess game, encapsulating its specific movement logic and characteristics.

#### 8.1. Requirements for Pawn Class:

- **Class Definition:**
    - Define the `Pawn` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Define a private attribute `chessMatch` to manage the context of the chess match.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board`, `Color`, and `ChessMatch` to initialize the pawn piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the pawn.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the pawn, allowing it to move one square forward if the target position is
      unoccupied.
    - Allow the pawn to move two squares forward from its starting position if both squares are unoccupied.
    - Implement the diagonal capture moves for the pawn, allowing it to capture opponent pieces diagonally.
    - Ensure that the pawn can move as long as the target positions are within the board boundaries and not occupied by
      another piece of the same color.

- **Special Moves:**
    - Implement the logic for the en passant move within the `possibleMoves()` method, allowing the pawn to capture en
      passant if the conditions are met (the opponent's pawn has moved two squares forward in the previous move).

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the pawn.
    - Ensure that the `toString()` method returns the emoji "♙" to represent the pawn.

***

### 9. Queen Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Queen` class. The `Queen`
class represents the queen piece in the chess game, encapsulating its specific movement logic and characteristics.

#### 9.1. Requirements for Queen Class:

- **Class Definition:**
    - Define the `Queen` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board` and `Color` to initialize the queen piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the queen.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the queen, allowing it to move in any direction (vertically, horizontally, and
      diagonally).
    - Ensure that the queen can move as long as the target positions are within the board boundaries and not occupied by
      another piece of the same color.
    - Allow the queen to capture opponent pieces by moving to their positions.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the queen.
    - Ensure that the `toString()` method returns the emoji "♕" to represent the queen.

***

### 10. Rook Class - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `Rook` class. The `Rook`
class represents the rook piece in the chess game, encapsulating its specific movement logic and characteristics.

#### 10.1. Requirements for Rook Class:

- **Class Definition:**
    - Define the `Rook` class as a public class that extends `ChessPiece`.
    - Ensure that the class is located in the `com.souza.charles.chessgame.pieces` package.

- **Attributes and Encapsulation:**
    - Inherit attributes `position`, `board`, and `color` from the `ChessPiece` superclass.
    - Use the principle of encapsulation to control access to these attributes.

- **Constructors:**
    - Provide a constructor with parameters for `Board` and `Color` to initialize the rook piece.
    - Ensure the constructor calls the superclass constructor to initialize the inherited attributes.

- **Movement Logic:**
    - Implement the method `boolean[][] possibleMoves()` to define the possible moves for the rook.
    - Use a 2D boolean array to represent the possible moves on the board.
    - Implement the movement logic for the rook, allowing it to move vertically and horizontally across the board.
    - Ensure that the rook can move as long as the target positions are within the board boundaries and not occupied by
      another piece of the same color.
    - Allow the rook to capture opponent pieces by moving to their positions.

- **ToString Method:**
    - Override the `toString()` method from the `Object` class to provide a string representation of the rook.
    - Ensure that the `toString()` method returns the emoji "♖" to represent the rook.

***

## Application Layer:

### 1. UI and Program Classes - Implementation Details:

This section provides detailed requirements and specifications for the implementation of the `UI` and `Program` classes.
These classes handle the user interface and the main application logic for the chess game system, including printing the
board, reading user input, and managing the game flow.

#### 1.1. Requirements for UI Class:

- **Class Definition:**
    - Define the `UI` class as a public class to manage the user interface functionalities.
    - Ensure that the class is located in the `com.souza.charles.application` package.

- **ANSI Color Codes:**
    - Define constants for ANSI color codes to enable colored text and background in the console output.
    - Include colors such as `ANSI_RESET`, `ANSI_RED`, `ANSI_BLUE`, `ANSI_GREEN`, etc.

- **Clear Screen Method:**
    - Implement the `clearScreen()` method to clear the console screen using ANSI escape codes.

- **Read Chess Position Method:**
    - Implement the `readChessPosition(Scanner scanner)` method to read a chess position from the user input.
    - Validate the input and throw an `InputMismatchException` if the input is invalid.

- **Print Match Method:**
    - Implement the `printMatch(ChessMatch chessMatch, List<ChessPiece> captured)` method to print the current state of
      the chess match, including the board, captured pieces, turn, and game status.

- **Print Board Methods:**
    - Implement the `printBoard(ChessPiece[][] pieces)` method to print the chess board without highlighting possible
      moves.
    - Implement the `printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves)` method to print the chess board with
      highlighting for possible moves.

- **Print Piece Method:**
    - Implement the private `printPiece(ChessPiece piece, int row, int col)` method to print a single chess piece on the
      board, using different colors for different players.

- **Print Captured Pieces Method:**
    - Implement the private `printCapturedPieces(List<ChessPiece> captured)` method to print the list of captured
      pieces, grouped by player color.

#### 2.2. Requirements for Program Class:

- **Class Definition:**
    - Define the `Program` class as a public class to manage the main application logic.
    - Ensure that the class is located in the `com.souza.charles.application` package.

- **Main Method:**
    - Implement the `main(String[] args)` method as the entry point of the application.
    - Initialize a `Scanner` object for reading user input and a `ChessMatch` object to represent the chess game.

- **Game Loop:**
    - Implement a game loop that continues until the game is in checkmate.
    - Within the game loop, clear the screen, print the match state, and read the source and target positions for the
      next move.
    - Execute the move and handle any exceptions, such as `ChessException` and `InputMismatchException`.

- **Promotion Logic:**
    - Implement logic to handle pawn promotion within the game loop, allowing the user to specify the type of piece for
      promotion.

***

## Exception Classes:

This section provides detailed requirements and specifications for the implementation of the `BoardException` and
`ChessException` classes. These classes handle custom exceptions specific to the board and chess game logic.

#### 1.1. Requirements for BoardException Class:

- **Class Definition:**
    - Define the `BoardException` class as a public class that extends `RuntimeException`.
    - Ensure that the class is located in the `com.souza.charles.boardgame` package.

- **Constructor:**
    - Provide a constructor with a parameter for the exception message.
    - Ensure the constructor calls the superclass constructor to initialize the exception message.

#### 1.2. Requirements for ChessException Class:

- **Class Definition:**
    - Define the `ChessException` class as a public class that extends `RuntimeException`.
    - Ensure that the class is located in the `com.souza.charles.chessgame` package.

- **Constructor:**
    - Provide a constructor with a parameter for the exception message.
    - Ensure the constructor calls the superclass constructor to initialize the exception message.

