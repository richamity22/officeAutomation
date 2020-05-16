import com.comp.autors.helper.assets.office365.*;

public class main {


    public static  void main(String[] args){


        //tests

        //sharepoint
        /*
        SharePointHelperImpl sharePointHelper = new SharePointHelperImpl();
        sharePointHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        sharePointHelper.createFolder("root/folder1/folder2");
        sharePointHelper.downloadFile("root/folder1/folder2/test.docx");*/




        //onedrive
        OneDriveHelperImpl oneDriveHelper = new OneDriveHelperImpl();

        oneDriveHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        oneDriveHelper.navigateTo("root/folder1/folder2/folder5");
        //oneDriveHelper.createFolder("root/folder1/folder2");
        //oneDriveHelper.downloadFile("root/folder1/folder2/test.docx");



        //teams
        /*

        TeamsHelperImpl teamsHelper = new TeamsHelperImpl();

        teamsHelper.login("tester@automation365tests.onmicrosoft.com","Art123q4e!54");
        teamsHelper.createFolder("root/folder1/folder2");
        teamsHelper.downloadFile("root/folder1/folder2/test.docx");*/
    }
}
