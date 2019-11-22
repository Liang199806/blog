package com.niit.web.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Liang
 * @ClassName ImageUtil
 * @Description TODO
 * @Date 2019/11/19
 * @Version 1.0
 **/
public class ImageUtil {
    public static BufferedImage getImage(int width, int height,String s){
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) img.getGraphics();
        graphics.setBackground(Color.CYAN);
        graphics.fillRect(0,0,width,height);
        graphics.setPaint(Color.GREEN);
        Font font = new Font("Serif",Font.BOLD,10);
        graphics.setFont(font);
        graphics.drawString(s,width/6,height/3);
        return img;
    }

    public static void main(String[] args) throws Exception {
        BufferedImage img = ImageUtil.getImage(240,120,CodeUtil.getRandomCode());
        File file = new File("D:/10.jpg");
        ImageIO.write(img,"jpg",file);
    }
}
