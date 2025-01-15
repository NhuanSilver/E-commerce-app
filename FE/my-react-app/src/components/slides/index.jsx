import Slide from "./slide"

export default function Slides() {
    const slides = [
        {
            imgLink: 'https://im.uniqlo.com/global-cms/spa/res52ba91dae6deeb98feeb0baf2fb0a4e5fr.jpg',
            title: 'Đón Xu Hướng Mới Cùng UNIQLO',
            text: 'Sẵn sàng đón mùa mới với Xu Hướng Thời Trang 2025.'
        },
        {
            imgLink: 'https://image.uniqlo.com/UQ/ST3/jp/imagesother/000_PLP/Jeans/25SS/WOMEN/KV-women-pc_gl.jpg',
            title: 'BST quần Jeans',
            text: 'Đã đến lúc làm mới tủ đồ của bạn với BST quần Jeans từ kiểu dáng ôm đến dáng rộng. Hãy chọn kiểu phù hợp với bạn.'
        }
    ]

    return (
        <>
            <div className="absolute start-0 end-0 top-0 bottom-0 overflow-y-hidden">
                {slides.map((slide, index) => <Slide slide={slide} key={index}/>)}
            </div>
        </>
    )
}