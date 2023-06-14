package ra.run;

import ra.config.Config;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.model.Singer;
import ra.model.Song;

import java.util.Date;

public class MusicManagement {
    static SingerController singerController = new SingerController();
    static SongController songController = new SongController();
    public static void main(String[] args) {
        while(true){
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("nhập lựa chọn của ban");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    managerSinger();
                    break;
                case 2:
                    managerSong();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.out.println("Thoat");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1 đến 4");
            }
        }
    }

    // ---------------------- Singer ---------------------//
    public static void managerSinger(){
        int choice = 0;
        while(choice != 5){
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4.Xóa ca sĩ theo mã id");
            System.out.println("5.Thoát");
            System.out.println("nhập lựa chọn của ban");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // them ca si
                    addSinger();
                    break;
                case 2:
                    // show all
                    showAllSinger();
                    break;
                case 3:
                    // update theo id
                    updateSinger();
                    break;
                case 4:
                    // xoa theo id
                    deleteSinger();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void addSinger(){
        System.out.println("nhập số lượng ca sĩ cần thêm mới");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập ca sĩ thứ "+ (i+1));
            Singer singer = new Singer();
            singer.setSingerId(i+1);
            System.out.println("Nhap tên ca sĩ");
            singer.setSingerName(Config.scanner().nextLine());
            System.out.println("Nhap tuoi ca sĩ");
            singer.setAge(Config.scanner().nextInt());
            System.out.println("Nhap quốc tịch ca sĩ");
            singer.setNationality(Config.scanner().nextLine());
            System.out.println("Nhap gioi tinh: true or false");
            singer.setGender(Config.scanner().nextBoolean());
            System.out.println("Nhap thể loại");
            singer.setGenre(Config.scanner().nextLine());
            singerController.saveSinger(singer);
        }
    }

    public static void showAllSinger(){
        if(singerController.getSize() == 0){
            System.err.println("danh sách trống");
        } else {
            for (Singer singer : singerController.getAllSinger()) {
                if (singer != null) {
                    System.out.println(singer);
                }
            }
        }
    }

    public static  void  updateSinger(){
        System.out.println(" hãy nhập vào id của ca sĩ muốn sửa");
        int id = Config.scanner().nextInt();
        Singer singer = new Singer();
        singer.setSingerId(id);
        System.out.println("Nhap tên ca sĩ");
        singer.setSingerName(Config.scanner().nextLine());
        System.out.println("Nhap tuoi ca sĩ");
        singer.setAge(Config.scanner().nextInt());
        System.out.println("Nhap quốc tịch ca sĩ");
        singer.setNationality(Config.scanner().nextLine());
        System.out.println("Nhap gioi tinh: true or false");
        singer.setGender(Config.scanner().nextBoolean());
        System.out.println("Nhap thể loại");
        singer.setGenre(Config.scanner().nextLine());
        singerController.updateSinger(singer);
    }

    public static void deleteSinger(){
        System.out.println(" hãy nhập vào id của ca sĩ muốn xoá");
        int id = Config.scanner().nextInt();
        singerController.deleteSinger(id);
    }

    //---------------------------- Song -------------------------//
    public static void managerSong(){
        int choice = 0;
        while(choice != 5){
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3.Thay đổi thông tin bài hát theo mã id");
            System.out.println("4.Xóa bài hát theo mã id");
            System.out.println("5.Thoát");
            System.out.println("nhập lựa chọn của ban");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // them bai hat
                    addSong();
                    break;
                case 2:
                    // show all
                    showAllSong();
                    break;
                case 3:
                    // update theo id
                    updateSong();
                    break;
                case 4:
                    // xoa theo id
                    deleteSong();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void addSong(){
        System.out.println("nhập số lượng bài hát cần thêm mới");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập bài hát thứ "+ (i+1));
            Song song = new Song();
            System.out.println("Nhap mã bài hát");
            song.setSongId(Config.scanner().nextLine());
            System.out.println("Nhap tên bài hát");
            song.setSongName(Config.scanner().nextLine());
            System.out.println("Nhap mô tả bài hát");
            song.setDescriptions(Config.scanner().nextLine());

            while(true) {
                System.out.println("Nhập id cua ca si");
                int singerId = Config.scanner().nextInt();
                Singer singer = singerController.findById(singerId);
                if(singer ==null){
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                }else {
                    song.setSinger(singer);
                    break;
                }
            }
            song.setCreatedDate(new Date());
            System.out.println("Nhap ngươi sáng tác");
            song.setSongWriter(Config.scanner().nextLine());
            System.out.println("Nhap trang thai: true or false");
            song.setSongStatus(Config.scanner().nextBoolean());
            songController.saveSong(song);
        }
    }

    public static void showAllSong(){
        if(songController.getSize() == 0){
            System.err.println("danh sách trống");
        } else {
            for (Song song : songController.getAllSong()) {
                if (song != null) {
                    System.out.println(song);
                }
            }
        }
    }

    public static  void  updateSong(){
        System.out.println(" hãy nhập vào id của bài hat muốn sửa");
        String id = Config.scanner().nextLine();
        Song song = new Song();
        System.out.println("Nhap mã bài hát");
        song.setSongId(Config.scanner().nextLine());
        System.out.println("Nhap tên bài hát");
        song.setSongName(Config.scanner().nextLine());
        System.out.println("Nhap mô tả bài hát");
        song.setDescriptions(Config.scanner().nextLine());

        while(true) {
            System.out.println("Nhập id cua bai hát muốn sửa");
            int singerId = Config.scanner().nextInt();
            Singer singer = singerController.findById(singerId);
            if(singer ==null){
                System.err.println("Id không tôn tại, vui lòng nhập lại");
            }else {
                song.setSinger(singer);
                break;
            }
        }
        song.setCreatedDate(new Date());
        System.out.println("Nhap ngươi sáng tác");
        song.setSongWriter(Config.scanner().nextLine());
        System.out.println("Nhap trang thai: true or false");
        song.setSongStatus(Config.scanner().nextBoolean());
        songController.updateSong(song, id);
    }

    public static void deleteSong(){
        System.out.println(" hãy nhập vào id của bài hát muốn xoá");
        String id = Config.scanner().nextLine();
        songController.deleteSong(id);
    }

    //----------------- Search ---------------//
    public static void search(){
        int choice = 0;
        while(choice != 5){
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại .");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5.Thoát");
            System.out.println("nhập lựa chọn của ban");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    searchSong();
                    break;
                case 2:
                    searchSinger();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void searchSong(){
        System.out.println("hãy nhập vào tên ca sĩ hoặc thể loại");
        String str = Config.scanner().nextLine();
        for (Song song : songController.getAllSong()) {
            if(song.getSinger().getSingerName().equals(str) || song.getSinger().getGenre().equals(str)) {
                System.out.println(song);
            } else {
                System.out.println("khong tim thay");
            }
        }
    }

    public static void searchSinger(){
        System.out.println("hãy nhập vào tên ca sĩ hoặc thể loại");
        String str = Config.scanner().nextLine();
        for (Singer singer : singerController.getAllSinger()) {
            if(singer.getSingerName().equals(str) || singer.getGenre().equals(str)) {
                System.out.println(singer);
            } else {
                System.out.println("khong tim thay");
            }
        }
    }
}
