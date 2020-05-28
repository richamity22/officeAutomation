import com.comp.autors.helper.assets.office365.*;

public class main {


    public static  void main(String[] args){


        //tests

        //sharepoint

        //SharePointHelperImpl sharePointHelper = new SharePointHelperImpl();
        //sharePointHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        //sharePointHelper.navigateTo("root/folder1/folder2");
        //sharePointHelper.shareFolder("root/folder1/folder2", "user1");
        //sharePointHelper.unShareFolder("root/folder1/folder2");
        //sharePointHelper.createFolder("root/folder1/folder2/folder78");

        //sharePointHelper.downloadFile("root/folder1/folder2/test.docx");




        //onedrive
        OneDriveHelperImpl oneDriveHelper = new OneDriveHelperImpl();
        oneDriveHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        //oneDriveHelper.navigateTo("root/folder1/folder2/folder5");
        //oneDriveHelper.createFolder("root/folder1/folder2/folder6/foldertt7/great/allpossibilities/");
        //oneDriveHelper.downloadFile("root/folder1/folder2/test.docx");
        //oneDriveHelper.shareFolder("root/folder788","user1@automation365tests.onmicrosoft.com");
        //oneDriveHelper.shareFile("root/folder1/folder2/test.docx","user1@automation365tests.onmicrosoft.com");
        //oneDriveHelper.unShareFolder("root/folder788");
        //oneDriveHelper.unShareFile("root/folder1/folder2/test.docx");
        //oneDriveHelper.renameFolder("root/folder1/","folder788");
        //oneDriveHelper.renameFile("root/folder1/folder2/Book3451.xlsx","Nook2");
        //oneDriveHelper.deleteFile("root/folder1/folder2/Nook2.xlsx");
        //oneDriveHelper.deleteFolder("root/folder1/folder2/folder6/foldertt7/great/allpossibilities");
        //oneDriveHelper.viewFile("root/folder788/folder2/test.docx");
        //oneDriveHelper.modifyFile("root/folder788/folder2/test.docx","Text Added");
        //oneDriveHelper.copyFileTo("root/folder788/folder2/test.docx","root/folder788/");
        //oneDriveHelper.moveFileTo("root/folder788/folder2/DocumentMoved.docx",
                //"root/folder788/");


        //teams


        //TeamsHelperImpl teamsHelper = new TeamsHelperImpl();

        //teamsHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        //teamsHelper.navigateTo("root/folder788");
        //oneDriveHelper.copyFileTo("root/folder788/folder2/test.docx","root/folder788/");
        //teamsHelper.createFolder("root/folder788/folder2/folder5678");
        //teamsHelper.shareFolder("root/folder788/folder2/folder5678", "user1");
        //teamsHelper.downloadFile("root/folder1/folder2/test.docx");
    }
}
