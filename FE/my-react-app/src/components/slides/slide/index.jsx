export default function Slide({ slide }) {
    return (
      <>
        <div
          style={{ backgroundImage: `url(${slide.imgLink})` }}
          className="w-full h-full bg-cover bg-center bg-no-repeat"
        >
          <div className="w-full h-24 bg-gradient-to-b from-zinc-400 to-transparent"></div>
        </div>
      </>
    );
  }
  