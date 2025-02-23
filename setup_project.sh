#!/bin/bash

# Base directory for the project
BASE_DIR="src"

# Function to create directories and files
create_structure() {
    # Create directories
    mkdir -p "$BASE_DIR/engine/board"
    mkdir -p "$BASE_DIR/model/card/standard"
    mkdir -p "$BASE_DIR/model/card/wild"
    mkdir -p "$BASE_DIR/model/player"
    mkdir -p "$BASE_DIR/exception"
    mkdir -p "$BASE_DIR/test"  # Create test directory
    mkdir -p "$BASE_DIR/view"

    # Create files in engine/
    touch "$BASE_DIR/engine/GameManager.java"
    touch "$BASE_DIR/engine/Game.java"

    # Create files in engine/board/
    touch "$BASE_DIR/engine/board/BoardManager.java"
    touch "$BASE_DIR/engine/board/Board.java"
    touch "$BASE_DIR/engine/board/Cell.java"
    touch "$BASE_DIR/engine/board/CellType.java"
    touch "$BASE_DIR/engine/board/SafeZone.java"

    # Create files in model/
    touch "$BASE_DIR/model/Colour.java"

    # Create files in model/card/
    touch "$BASE_DIR/model/card/Card.java"
    touch "$BASE_DIR/model/card/Deck.java"

    # Create files in model/card/standard/
    touch "$BASE_DIR/model/card/standard/Standard.java"
    touch "$BASE_DIR/model/card/standard/Suit.java"
    touch "$BASE_DIR/model/card/standard/Ace.java"
    touch "$BASE_DIR/model/card/standard/King.java"
    touch "$BASE_DIR/model/card/standard/Queen.java"
    touch "$BASE_DIR/model/card/standard/Jack.java"
    touch "$BASE_DIR/model/card/standard/Ten.java"
    touch "$BASE_DIR/model/card/standard/Seven.java"
    touch "$BASE_DIR/model/card/standard/Five.java"
    touch "$BASE_DIR/model/card/standard/Four.java"

    # Create files in model/card/wild/
    touch "$BASE_DIR/model/card/wild/Wild.java"
    touch "$BASE_DIR/model/card/wild/Burner.java"
    touch "$BASE_DIR/model/card/wild/Saver.java"

    # Create files in model/player/
    touch "$BASE_DIR/model/player/Player.java"
    touch "$BASE_DIR/model/player/CPU.java"
    touch "$BASE_DIR/model/player/Marble.java"

    # Create files in exception/
    touch "$BASE_DIR/exception/GameException.java"
    touch "$BASE_DIR/exception/InvalidSelectionException.java"
    touch "$BASE_DIR/exception/InvalidCardException.java"
    touch "$BASE_DIR/exception/InvalidMarbleException.java"
    touch "$BASE_DIR/exception/SplitOutOfRangeException.java"
    touch "$BASE_DIR/exception/ActionException.java"
    touch "$BASE_DIR/exception/IllegalMovementException.java"
    touch "$BASE_DIR/exception/IllegalSwapException.java"
    touch "$BASE_DIR/exception/IllegalDestroyException.java"
    touch "$BASE_DIR/exception/CannotFieldException.java"
    touch "$BASE_DIR/exception/CannotDiscardException.java"

    # Create test directory (empty for now)

    # Placeholder file to avoid empty dir warnings.
    touch "$BASE_DIR/test/.keep"
}

# Execute the function to create the structure and files.
create_structure

echo "Project structure created successfully!"
