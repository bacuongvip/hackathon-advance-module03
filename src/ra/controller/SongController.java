package ra.controller;

import ra.model.Song;
import ra.service.SongService;

public class SongController {
    private SongService songService = new SongService();
    public void saveSong(Song song){
        songService.saveSong(song);
    }
    public Song[] getAllSong(){
        return songService.getAllSong();
    }
    public  int getSize(){
        return songService.getSize();
    }
    public void updateSong(Song song, String id){
        songService.updateSong(song, id);
    }
    public void deleteSong(String id){
        songService.deleteSong(id);
    }
}
