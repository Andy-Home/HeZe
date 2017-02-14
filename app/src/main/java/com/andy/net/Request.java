package com.andy.net;

/**
 * 通过该接口调用单个命令
 * <p>
 * Created by andy on 17-2-14.
 */

public class Request {
    private Command command;

    public Request(Command command) {
        this.command = command;
    }

    /**
     * 设置命令请求
     *
     * @param command 命令
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行请求
     */
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                command.run();
            }
        }).start();
    }
}
