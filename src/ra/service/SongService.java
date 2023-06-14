package ra.service;

import ra.model.Song;

public class SongService {
    private Song[] listSong = new Song[100];
    private int size;
    public Song[] getAllSong(){
        return listSong;
    }
    public int getSize(){
        return size;
    }

    public boolean saveSong(Song song){
        for (int i = 0; i < listSong.length; i++) {
            if(listSong[i]==null){
                listSong[i] = song;
                break;
            }
        }
        System.out.println("Thêm mới thành công");
        size++;
        return true;
    }

    public boolean updateSong(Song song, String id){
        for (int i = 0; i < listSong.length; i++) {
            if (listSong[i]!=null && listSong[i].getSongId().equals(id)){
                listSong[i] = song;
                break;
            }
        }
        System.out.println("Cập nhật thành công");
        return true;
    }
    public boolean deleteSong(String id){
        for (int i = 0; i < listSong.length ; i++) {
            if (listSong[i]!=null && listSong[i].getSongId().equals(id)){
                listSong[i] = null;
                break;
            }
        }
        size--;
        System.out.println("Xóa thành công");
        return true;
    }
}
