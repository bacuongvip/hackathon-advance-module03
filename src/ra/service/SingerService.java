package ra.service;


import ra.model.Singer;

public class SingerService {
    private Singer[] listSinger = new Singer[100];
    private int size;
    public Singer[] getAllSinger(){
        return listSinger;
    }
    public int getSize(){
        return size;
    }
    public Singer findById(int id){
        for (Singer singer :listSinger) {
            if (singer!=null) {
                if (singer.getSingerId() == id) {
                    return singer;
                }
            }
        }
        return null;
    }

    public boolean saveSinger(Singer singer){
        for (int i = 0; i < listSinger.length; i++) {
            if(listSinger[i]==null){
                listSinger[i] = singer;
                break;
            }
        }
        System.out.println("Thêm mới thành công");
        size++;
        return true;
    }

    public boolean updateSinger(Singer singer){
        for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i]!=null && listSinger[i].getSingerId()== singer.getSingerId()){
                listSinger[i] = singer;
                break;
            }
        }
        System.out.println("Cập nhật thành công");
        return true;
    }

    public boolean deleteSinger(int id){
        for (int i = 0; i < listSinger.length ; i++) {
            if (listSinger[i]!=null && listSinger[i].getSingerId() == id){
                listSinger[i] = null;
                break;
            }
        }
        size--;
        System.out.println("Xóa thành công");
        return true;
    }
}
