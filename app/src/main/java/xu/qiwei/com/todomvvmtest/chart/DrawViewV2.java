package xu.qiwei.com.todomvvmtest.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by xuqiwei on 17-3-17.
 */

public class DrawViewV2 extends View {
    private DrawBean drawBean;
    private static final int ZHUSPACERATE = 1;
    private static final int ZHUWIDTH = 4;
    private static final int ZHUTOTALWIDTH = ZHUSPACERATE + ZHUWIDTH;

    public DrawViewV2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDrawBean(DrawBean drawBean) {
        this.drawBean = drawBean;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float totalVertial = canvas.getHeight() - drawBean.getMarTop() - drawBean.getMarBtm();
        float totalHorizal = canvas.getWidth() - drawBean.getMarLeft() - drawBean.getMarRight();

        drawXaxis(canvas, totalVertial, totalHorizal);
        drawYaxis(canvas, totalVertial);
        drawZhu(canvas, totalVertial, totalHorizal);
    }

    private void drawZhu(Canvas canvas, float totalVertial, float totalHorizal) {
        List<StatisData> datas = drawBean.getxDataList();
        int dataCount = datas.size();
//        计算所需要的基本信息
        drawBean.setZhuSpace(getZhuSpace(totalHorizal));
        drawBean.setZhuWidth(getZhuWidth(totalHorizal));
        int totalScore = drawBean.getTotalScore();

        float zhuWidth = drawBean.getZhuWidth();
        float zhuSpace = drawBean.getZhuSpace();
        float marLeft = drawBean.getMarLeft();
        float marTop = drawBean.getMarTop();
        for (int i = 0; i < dataCount; i++) {
            StatisData temp = datas.get(i);
            float allZhuHeight = totalVertial * temp.getFillData() / totalScore;
            float zhuTopHeight = allZhuHeight * (temp.getFillData() - temp.getInnerData()) / temp.getFillData();
            float zhuBtnHeight = allZhuHeight * temp.getInnerData() / temp.getFillData();

            float ax = marLeft + i * (zhuSpace + zhuWidth) + zhuSpace;
            float ay = marTop + (totalVertial - allZhuHeight);
            float cx = ax + zhuWidth;
            float cy = ay;
            float bx = ax;
            float by = ay + zhuTopHeight;
            float dx = ax + zhuWidth;
            float dy = ay + zhuTopHeight;
            float ex = ax;
            float ey = ay + allZhuHeight;
            float fx = ax + zhuWidth;
            float fy = ay + allZhuHeight;
            drawTopZhu(ax, ay, dx, dy, canvas);
            drawBtnZhu(bx, by, fx, fy, canvas);
            drawZhuName((ex+fx)/2, ey, temp.getDataName(), canvas);
            drawTopName((ax + cx) / 2, ay, temp.getFillData(), canvas);
            drawBtnName((bx + dx) / 2, (by + ey) / 2, temp.getInnerData(), canvas);
//
        }
    }

    private void drawTopName(float ax, float ay, int fillData, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40f);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(fillData + "", ax, ay, paint);

    }

    private void drawBtnName(float bx, float by, int innerData, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40f);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(innerData + "", bx, by, paint);
    }

    private void drawZhuName(float ex, float ey, String dataName, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40f);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(dataName, ex, ey + 40, paint);
    }

    private void drawTopZhu(float ax, float ay, float dx, float dy, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(204, 204, 204));
        canvas.drawRect(ax, ay, dx, dy, paint);

    }

    private void drawBtnZhu(float bx, float by, float fx, float fy, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0, 153, 255));
        canvas.drawRect(bx, by, fx, fy, paint);
    }


    //    柱状体间隔
    private float getZhuSpace(float totalHorizal) {
        int xListCount = drawBean.getxDataList().size();
        return (totalHorizal / xListCount) * ZHUSPACERATE / ZHUTOTALWIDTH;
    }

    //    柱状体的宽度
    private float getZhuWidth(float totalHorizal) {
        int xListCount = drawBean.getxDataList().size();
        return (totalHorizal / xListCount) * ZHUWIDTH / ZHUTOTALWIDTH;
    }

    //    画Y轴
    private void drawYaxis(Canvas canvas, float totalVertial) {
      /*  if (paint==null) {
            paint = new Paint();
        }*/
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawLine(drawBean.getMarLeft(), 0, drawBean.getMarLeft(), drawBean.getMarTop() + totalVertial, paint);
        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStrokeWidth(3);
        textPaint.setTextSize(40f);
        textPaint.setAntiAlias(true);

        int verticalDataCount = drawBean.getyTextList().size();
        float verticalSpace = totalVertial / verticalDataCount;
        for (int i = 0; i <= verticalDataCount; i++) {
            if (i != verticalDataCount) {
                float kx = drawBean.getMarLeft();
                float ky = drawBean.getMarTop() + i * verticalSpace;
                float lx = kx + 20;
                float ly = ky;
                canvas.drawLine(kx, ky, lx, ly, paint);

            }
            String lefttext = drawBean.getTotalScore() * i / verticalDataCount + "";
            canvas.drawText(lefttext, 10, (verticalDataCount - i) * verticalSpace + drawBean.getMarTop(), textPaint);
        }

    }

    //    画X轴
    private void drawXaxis(Canvas canvas, float totalVertial, float totalHorizal) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawLine(
                drawBean.getMarLeft(),
                drawBean.getMarTop() + totalVertial,
                drawBean.getMarLeft()+totalHorizal+drawBean.getMarRight(),
                drawBean.getMarTop() + totalVertial, paint
        );
    }

}
