package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

public class SingerController {
    private SingerService singerService = new SingerService();
    public void saveSinger(Singer singer){
        singerService.saveSinger(singer);
    }
    public Singer findById(int id){
        return singerService.findById(id);
    }
    public Singer[] getAllSinger(){
        return singerService.getAllSinger();
    }
    public  int getSize(){
        return singerService.getSize();
    }
    public void updateSinger(Singer singer){
        singerService.updateSinger(singer);
    }
    public void deleteSinger(int id){
        singerService.deleteSinger(id);
    }

}
