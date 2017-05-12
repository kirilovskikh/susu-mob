package com.kirilovskikh.labs.data.news

import com.kirilovskikh.labs.data.NewsModel
import rx.Observable

/**
 * Created by kirilovskikh on 13.05.17.
 */
class NewsRepository {

    fun fetch(lastModel: NewsModel?): Observable<List<NewsModel>> {
        return Observable.create<List<NewsModel>> { subscriber ->
            Thread.sleep(2000)

            val items = mutableListOf<NewsModel>()

            val startId = (lastModel?.id?.plus(1)) ?: 1
            val endId = startId + 20

            for (i in startId..endId) {

                val model = if (i % 4 == 0L) {
                    NewsModel(i, image = "https://hi-news.ru/wp-content/uploads/2017/01/asteroid-650x387.jpg", text = "$i $i $i $i")
                } else {
                    NewsModel(i, text = "$i $i $i $i")
                }

                if (i % 10 == 0L) {
                    model.isAdvertising = true
                    model.image = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/FullMoon2010.jpg/290px-FullMoon2010.jpg"
                }

                items.add(model)
            }

            subscriber.onNext(items)
        }

    }

}