package engine.board;

import engine.GameManager;
import model.Colour;
import java.util.ArrayList;

public class Board implements BoardManager {
    private final GameManager gameManager;
    private final ArrayList<Cell> track;
    private final ArrayList<SafeZone> safeZones;
    private int splitDistance;

    public Board(ArrayList<Colour> colourOrder, GameManager gameManager) {
        this.gameManager = gameManager;
        this.track = new ArrayList<>();
        this.safeZones = new ArrayList<>();
        this.splitDistance = 3;

        // Initialize the track with 100 cells
        initializeTrack();

        // Initialize safe zones for each color
        initializeSafeZones(colourOrder);

        // Assign trap cells
        assignTrapCell();
    }

    private void initializeTrack() {
        track.clear();
        for (int i = 0; i < 100; i++) {
            CellType type = CellType.NORMAL;
            if (i == 0 || i == 25 || i == 50 || i == 75) {
                type = CellType.BASE;
            } else if (i == 23 || i == 48 || i == 73 || i == 98) {
                type = CellType.ENTRY;
            }
            Cell cell = new Cell(type);
            track.add(cell);
        }
    }


    private void initializeSafeZones(ArrayList<Colour> colourOrder) {
        for (Colour colour : colourOrder) {
            safeZones.add(new SafeZone(colour));
        }
    }

    private void assignTrapCell() {
        int trapsAssigned = 0;
        while (trapsAssigned < 8) {
            int randomIndex = (int) (Math.random() * 100);
            Cell cell = track.get(randomIndex);
            if (cell.getCellType() == CellType.NORMAL && !cell.isTrap()) {
                cell.setTrap(true);
                trapsAssigned++;
            }
        }
    }

    @Override
    public int getSplitDistance() {
        return splitDistance;
    }

    public void setSplitDistance(int splitDistance) {
        this.splitDistance = splitDistance;
    }

    public ArrayList<Cell> getTrack() {
        return track;
    }

    public ArrayList<SafeZone> getSafeZones() {
        return safeZones;
    }
}