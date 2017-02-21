package com.andy.net;

/**
 * 通过该接口调用单个命令
 * <p>
 * Created by andy on 17-2-14.
 */

public class Request {
    private Command command;

    public Request() {
    }

    public Request(Command command) {
        this.command = command;
    }

    /**
     * 设置命令请求
     *
     * @param command 命令
     */
    public Request setCommand(Command command) {
        this.command = command;
        return this;
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
