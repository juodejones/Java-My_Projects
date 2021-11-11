package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

public class Explanation {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(50);

                        for (int i = 0; i < 10 ; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }

                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(50);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread : " + new String(timeString));
                            buffer.flip();  
                            Thread.sleep(100);
                        }

                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
/*        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1pos = outputBytes.length;
            buffer.putInt(648);
            long int2pos = int1pos + Integer.BYTES;
            buffer.putInt(-987654);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3pos = int2pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            RandomAccessFile copyFile = new RandomAccessFile("dataCopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Number Transferred = " + numTransferred);

            ra.close();
            channel.close();
            copyFile.close();
            copyChannel.close();

//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int3 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int1pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            long str1pos = 0;
//            byte[] outputString = "Hello, World!".getBytes();
//            long newInt1pos = outputString.length;
//            long newInt2pos = newInt1pos + Integer.BYTES;
//            long str2pos = newInt2pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long newInt3pos =  str2pos + outputString2.length;
//
//            ByteBuffer intBuffer =ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(newInt1pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(newInt2pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(str1pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//
//            buffer.flip();
//            int numBytes = binChannel.write(buffer);
//            System.out.println("Num Bytes written : " + numBytes );
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//
//            intBuffer.putInt(136);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("Num Bytes written : " + numBytes );
//
//            intBuffer.flip();
//            intBuffer.putInt(-655468);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("Num Bytes written : " + numBytes );
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("byte buffer = " + new String(buffer.array()));
//            }
//
//            //Absolute Read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//
//            //Relative Read
//            //            intBuffer.flip();
//            //            numBytesRead = channel.read(intBuffer);
//            //            intBuffer.flip();
//            //            System.out.println(intBuffer.getInt());
//            //            intBuffer.flip();
//            //            numBytesRead = channel.read(intBuffer);
//            //            intBuffer.flip();
//            //            System.out.println(intBuffer.getInt());
//            channel.close();
//            ra.close();
//            System.out.println("outputBytes = " + new String(outputBytes));
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
