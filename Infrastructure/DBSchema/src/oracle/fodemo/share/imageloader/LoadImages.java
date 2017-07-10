package oracle.fodemo.share.imageloader;

import java.io.IOException;

import java.sql.SQLException;

import oracle.fodemo.share.imageloader.service.ImageLoaderServiceAMImpl;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;
import oracle.jbo.common.ampool.EnvInfoProvider;

public class LoadImages {
    public LoadImages() {
    }

    public static void main(String[] args) {
        String amDef = 
            "oracle.fodemo.share.imageloader.service.ImageLoaderServiceAM";
        String config = "ImageLoaderServiceAMLocal";
        EnvInfoProvider provider = new EnvProvider(args[0], args[1], args[2]);
//        EnvInfoProvider provider = new EnvProvider();
            ApplicationModule am = 
            Configuration.createRootApplicationModule(amDef, config, provider);
        ImageLoaderServiceAMImpl image = (ImageLoaderServiceAMImpl)am;
        try {
            String srcdir = args[3];
//                        image.loadImages();
            image.loadImages(srcdir);
        } catch (SQLException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        Configuration.releaseRootApplicationModule(am, true);
    }
}
