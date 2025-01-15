import { useState } from "react";

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
    ];

    const [currentIndex, setCurrentIndex] = useState(0);
    const changeSlide = (direction) => {
        let updatedIndex = currentIndex;
        if (direction === "next") {
            const isLastIndex = currentIndex >= slides.length - 1;
            updatedIndex = isLastIndex ? slides.length - 1 : currentIndex + 1;
        } else if (direction === "prev") {
            const isFirstIndex = currentIndex <= 0;
            updatedIndex = isFirstIndex ? 0 : currentIndex - 1;
        }
        setCurrentIndex(updatedIndex);
    };

    const handleWheel = (event) => {
        if (event.deltaY > 0) {
            changeSlide("next");
        } else {
            changeSlide("prev");
        }
    };

    const handleKeyDown = (event) => {
        if (event.key === "ArrowDown") {
            changeSlide("next");
        } else if (event.key === "ArrowUp") {
            changeSlide("prev");
        }
    };

    return (
        <div 
            tabIndex={0}
            onWheel={handleWheel} 
            onKeyDown={handleKeyDown} 
            className="absolute start-0 end-0 top-0 bottom-0 overflow-y-auto outline-none">
            <div 
                style={{ backgroundImage: `url(${slides[currentIndex].imgLink})` }}
                className="w-full h-full bg-cover bg-center bg-no-repeat">
                <div className="w-full h-24 bg-gradient-to-b from-zinc-400 to-transparent"></div>
            </div>
        </div>
    );
}
