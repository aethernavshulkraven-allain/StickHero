package com.example.stickhero;

public class homeMenu implements menu{
    @Override
    public void exitMenu() {

    }

    private playButton playGameButton;
    private settingsMenuButton openSettingsMenuButton;

    public void playGame() throws gameNotFoundError{
        //called by playGameButton
        gameplay game = new gameplay();
    }
}
